package br.com.rfasioli.mongodbpoc.interfaces.converters;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import br.com.rfasioli.mongodbpoc.interfaces.dtos.OperationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OperationDTOToOperationConverter implements Converter<OperationDTO, Operation> {
    private final ObjectMapper objectMapper;

    public OperationDTOToOperationConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Operation convert(OperationDTO source) {
        try {
            String operation = objectMapper.writeValueAsString(source);
            return Operation.newBuilder(objectMapper.readValue(operation, Operation.class)).build();

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
