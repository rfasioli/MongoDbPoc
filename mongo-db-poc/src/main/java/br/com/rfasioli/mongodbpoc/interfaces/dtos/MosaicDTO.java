package br.com.rfasioli.mongodbpoc.interfaces.dtos;

import br.com.rfasioli.mongodbpoc.business.domains.Mosaic;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

public class MosaicDTO {
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Mosaic.STATUS status;
    private String description;
    private String rawImageReference;
    private String NDVIRawImageReference;
    private String visualImageReference;
    private String NDVIVisualImageReference;

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
