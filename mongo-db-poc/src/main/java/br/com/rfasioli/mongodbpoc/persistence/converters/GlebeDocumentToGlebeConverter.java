package br.com.rfasioli.mongodbpoc.persistence.converters;

import br.com.rfasioli.mongodbpoc.business.domains.Glebe;
import br.com.rfasioli.mongodbpoc.persistence.documents.GlebeDocument;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;

public class GlebeDocumentToGlebeConverter implements Converter<GlebeDocument, Glebe> {
    private final ObjectMapper objectMapper;

    public GlebeDocumentToGlebeConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Glebe convert(GlebeDocument source) {
        try {
            String Glebe = objectMapper.writeValueAsString(source);
            return objectMapper.readValue(Glebe, Glebe.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
