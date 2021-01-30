package br.com.rfasioli.mongodbpoc.interfaces.dtos;

import br.com.rfasioli.mongodbpoc.business.domains.Field;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.geo.Polygon;

import java.time.LocalDateTime;
import java.util.List;

public class FieldDTO {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Field.STATUS status;
    private Polygon geometry;
    private List<MosaicDTO> mosaics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Field.STATUS getStatus() {
        return status;
    }

    public void setStatus(Field.STATUS status) {
        this.status = status;
    }

    public Polygon getGeometry() {
        return geometry;
    }

    public void setGeometry(Polygon geometry) {
        this.geometry = geometry;
    }

    public List<MosaicDTO> getMosaics() {
        return mosaics;
    }

    public void setMosaics(List<MosaicDTO> mosaics) {
        this.mosaics = mosaics;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .append("status", status)
                .append("mosaics", mosaics)
                .toString();
    }
}