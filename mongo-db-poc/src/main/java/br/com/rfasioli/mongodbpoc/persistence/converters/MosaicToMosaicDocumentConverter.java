package br.com.rfasioli.mongodbpoc.persistence.converters;

import br.com.rfasioli.mongodbpoc.business.domains.Mosaic;
import br.com.rfasioli.mongodbpoc.persistence.documents.MosaicDocument;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;

public class MosaicToMosaicDocumentConverter implements Converter<Mosaic, MosaicDocument> {
    private final ObjectMapper objectMapper;

    public MosaicToMosaicDocumentConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public MosaicDocument convert(Mosaic source) {
        try {
            String mosaic = objectMapper.writeValueAsString(source);
            return objectMapper.readValue(mosaic, MosaicDocument.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
