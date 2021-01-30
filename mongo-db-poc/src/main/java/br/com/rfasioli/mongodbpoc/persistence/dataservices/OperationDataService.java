package br.com.rfasioli.mongodbpoc.persistence.dataservices;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import br.com.rfasioli.mongodbpoc.persistence.documents.OperationDocument;
import br.com.rfasioli.mongodbpoc.persistence.repositories.OperationRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationDataService {
    private final Converter<Operation, OperationDocument> operationOperationDocumentConverter;
    private final Converter<OperationDocument, Operation> operationDocumentOperationConverter;
    private final OperationRepository operationRepository;

    public OperationDataService(Converter<Operation, OperationDocument> operationOperationDocumentConverter,
                                Converter<OperationDocument, Operation> operationDocumentOperationConverter,
                                OperationRepository operationRepository) {
        this.operationOperationDocumentConverter = operationOperationDocumentConverter;
        this.operationDocumentOperationConverter = operationDocumentOperationConverter;
        this.operationRepository = operationRepository;
    }

    public Operation save(Operation operation) {
        return operationDocumentOperationConverter.convert(
                operationRepository.save(
                        operationOperationDocumentConverter.convert(operation)));
    }

    public List<Operation> findAll() {
        return operationRepository.findAll().stream().map(o ->
                operationDocumentOperationConverter.convert(o)).collect(Collectors.toList());
    }

    public Operation findOne(String id) {
        return operationDocumentOperationConverter.convert(
                operationRepository.findById(id.toString())
                        .orElseThrow(() -> new RuntimeException("Operação não encontrada")));
    }

    public boolean updateStatus(String operationId, Operation.STATUS status) {
        return operationRepository.updateOperationStatus(operationId, status) > 0;
    }

}
