package br.com.rfasioli.mongodbpoc.persistence.documents;

import br.com.rfasioli.mongodbpoc.business.domains.Mosaic;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MosaicDocument implements Serializable {
    @Transient
    private String id;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Indexed
    private Mosaic.STATUS status;

    private String description;
    private String rawImageReference;
    private String NDVIRawImageReference;
    private String visualImageReference;
    private String NDVIVisualImageReference;

    public MosaicDocument() {
    }

    public MosaicDocument(String id,
                          LocalDateTime createdAt,
                          LocalDateTime modifiedAt,
                          Mosaic.STATUS status,
                          String description,
                          String rawImageReference,
                          String NDVIRawImageReference,
                          String visualImageReference,
                          String NDVIVisualImageReference) {
        this.id = id;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.status = status;
        this.description = description;
        this.rawImageReference = rawImageReference;
        this.NDVIRawImageReference = NDVIRawImageReference;
        this.visualImageReference = visualImageReference;
        this.NDVIVisualImageReference = NDVIVisualImageReference;
    }

    public static MosaicDocument of(String id,
                                    LocalDateTime createdAt,
                                    LocalDateTime modifiedAt,
                                    Mosaic.STATUS status,
                                    String description,
                                    String rawImageReference,
                                    String NDVIRawImageReference,
                                    String visualImageReference,
                                    String NDVIVisualImageReference) {
        return new MosaicDocument(id,
                createdAt,
                modifiedAt,
                status,
                description,
                rawImageReference,
                NDVIRawImageReference,
                visualImageReference,
                NDVIVisualImageReference);
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

    public Mosaic.STATUS getStatus() {
        return status;
    }

    public void setStatus(Mosaic.STATUS status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRawImageReference() {
        return rawImageReference;
    }

    public void setRawImageReference(String rawImageReference) {
        this.rawImageReference = rawImageReference;
    }

    public String getNDVIRawImageReference() {
        return NDVIRawImageReference;
    }

    public void setNDVIRawImageReference(String NDVIRawImageReference) {
        this.NDVIRawImageReference = NDVIRawImageReference;
    }

    public String getVisualImageReference() {
        return visualImageReference;
    }

    public void setVisualImageReference(String visualImageReference) {
        this.visualImageReference = visualImageReference;
    }

    public String getNDVIVisualImageReference() {
        return NDVIVisualImageReference;
    }

    public void setNDVIVisualImageReference(String NDVIVisualImageReference) {
        this.NDVIVisualImageReference = NDVIVisualImageReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MosaicDocument that = (MosaicDocument) o;

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
                .append("description", description)
                .append("rawImageReference", rawImageReference)
                .append("NDVIRawImageReference", NDVIRawImageReference)
                .append("visualImageReference", visualImageReference)
                .append("NDVIVisualImageReference", NDVIVisualImageReference)
                .toString();
    }
}
