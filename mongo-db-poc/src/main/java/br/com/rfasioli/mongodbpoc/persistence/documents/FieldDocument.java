package br.com.rfasioli.mongodbpoc.persistence.documents;

import br.com.rfasioli.mongodbpoc.business.domains.Field;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class FieldDocument {
    @Transient
    private String id;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    @Indexed
    private Field.STATUS status;

    private Polygon geometry;

    private List<MosaicDocument> mosaics;

    public FieldDocument() {
    }

    public FieldDocument(String id,
                         LocalDateTime createdAt,
                         LocalDateTime modifiedAt,
                         Field.STATUS status,
                         Polygon geometry,
                         List<MosaicDocument> mosaics) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.status = status;
        this.geometry = geometry;
        this.mosaics = mosaics;
    }

    public static FieldDocument of(String id,
                                   LocalDateTime createdAt,
                                   LocalDateTime modifiedAt,
                                   Field.STATUS status,
                                   Polygon geometry,
                                   List<MosaicDocument> mosaics) {
        return new FieldDocument(id,
                createdAt,
                modifiedAt,
                status,
                geometry,
                mosaics);
    }

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

    public List<MosaicDocument> getMosaics() {
        return mosaics;
    }

    public void setMosaics(List<MosaicDocument> mosaics) {
        this.mosaics = mosaics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        FieldDocument that = (FieldDocument) o;

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
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .append("status", status)
                .append("mosaics", mosaics)
                .toString();
    }
}