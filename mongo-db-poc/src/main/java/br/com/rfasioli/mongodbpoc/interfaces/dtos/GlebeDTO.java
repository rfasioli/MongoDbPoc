package br.com.rfasioli.mongodbpoc.interfaces.dtos;

import br.com.rfasioli.mongodbpoc.business.domains.Glebe;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.geo.Polygon;

import java.time.LocalDateTime;
import java.util.List;

public class GlebeDTO {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Glebe.STATUS status;
    private Polygon geometry;
    private List<FieldDTO> fields;

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

    public Glebe.STATUS getStatus() {
        return status;
    }

    public void setStatus(Glebe.STATUS status) {
        this.status = status;
    }

    public Polygon getGeometry() {
        return geometry;
    }

    public void setGeometry(Polygon geometry) {
        this.geometry = geometry;
    }

    public List<FieldDTO> getFields() {
        return fields;
    }

    public void setFields(List<FieldDTO> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .append("status", status)
                .append("fields", fields)
                .toString();
    }
}