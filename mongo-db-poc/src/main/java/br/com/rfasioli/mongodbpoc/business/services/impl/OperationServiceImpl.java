package br.com.rfasioli.mongodbpoc.business.services.impl;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import br.com.rfasioli.mongodbpoc.business.services.OperationUseCase;
import br.com.rfasioli.mongodbpoc.persistence.dataservices.OperationDataService;
import br.com.rfasioli.mongodbpoc.persistence.repositories.OperationDomainRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationUseCase {
    private final OperationDataService operationDataService;
    private final OperationDomainRepository operationDomainRepository;

    public OperationServiceImpl(OperationDataService operationDataService,
                                OperationDomainRepository operationDomainRepository) {
        this.operationDataService = operationDataService;
        this.operationDomainRepository = operationDomainRepository;
    }

    public Operation save(Operation operation) {
        operationDomainRepository.save(operation);
        return operationDataService.save(operation);
    }

    public List<Operation> findAll() {
        return operationDataService.findAll();
    }

    @Override
    public Operation findOne(String id) {
        return operationDataService.findOne(id);
    }

    @Override
    public Boolean updateStatus(String id, Operation.STATUS status) {
        return operationDataService.updateStatus(id, status);
    }

}
