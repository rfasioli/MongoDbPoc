package br.com.rfasioli.mongodbpoc.persistence.converters;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import br.com.rfasioli.mongodbpoc.persistence.documents.OperationDocument;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OperationDocumentToOperationConverter implements Converter<OperationDocument, Operation> {
    private final ObjectMapper objectMapper;

    public OperationDocumentToOperationConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Operation convert(OperationDocument source) {
        try {
            String Operation = objectMapper.writeValueAsString(source);
            return objectMapper.readValue(Operation, Operation.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
