package br.com.rfasioli.mongodbpoc.interfaces.converters;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import br.com.rfasioli.mongodbpoc.interfaces.dtos.OperationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OperationToOperationDTOConverter implements Converter<Operation, OperationDTO> {
    private final ObjectMapper objectMapper;

    public OperationToOperationDTOConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public OperationDTO convert(Operation source) {
        try {
            String operation = objectMapper.writeValueAsString(source);
            return objectMapper.readValue(operation, OperationDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
