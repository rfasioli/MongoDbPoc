package br.com.rfasioli.mongodbpoc.persistence.documents;

import br.com.rfasioli.mongodbpoc.business.domains.Glebe;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.List;

public class GlebeDocument {
    @Transient
    private String id;

    @Indexed
    private Glebe.STATUS status;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Polygon geometry;
    private List<FieldDocument> fields;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Glebe.STATUS getStatus() {
        return status;
    }

    public void setStatus(Glebe.STATUS status) {
        this.status = status;
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

    public Polygon getGeometry() {
        return geometry;
    }

    public void setGeometry(Polygon geometry) {
        this.geometry = geometry;
    }

    public List<FieldDocument> getFields() {
        return fields;
    }

    public void setFields(List<FieldDocument> fields) {
        this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GlebeDocument that = (GlebeDocument) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("status", status)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .append("fields", fields)
                .toString();
    }
}