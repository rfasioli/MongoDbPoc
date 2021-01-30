package br.com.rfasioli.mongodbpoc.persistence.converters;

import br.com.rfasioli.mongodbpoc.business.domains.Field;
import br.com.rfasioli.mongodbpoc.persistence.documents.FieldDocument;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;

public class FieldDocumentToFieldConverter implements Converter<FieldDocument, Field> {
    private final ObjectMapper objectMapper;

    public FieldDocumentToFieldConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Field convert(FieldDocument source) {
        try {
            String Field = objectMapper.writeValueAsString(source);
            return objectMapper.readValue(Field, Field.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
