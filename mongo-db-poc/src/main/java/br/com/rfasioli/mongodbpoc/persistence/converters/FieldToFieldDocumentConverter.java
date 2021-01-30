package br.com.rfasioli.mongodbpoc.persistence.converters;

import br.com.rfasioli.mongodbpoc.business.domains.Field;
import br.com.rfasioli.mongodbpoc.persistence.documents.FieldDocument;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;

public class FieldToFieldDocumentConverter implements Converter<Field, FieldDocument> {
    private final ObjectMapper objectMapper;

    public FieldToFieldDocumentConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public FieldDocument convert(Field source) {
        try {
            String Field = objectMapper.writeValueAsString(source);
            return objectMapper.readValue(Field, FieldDocument.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
