package br.com.rfasioli.mongodbpoc.interfaces.dtos;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class OperationDTO {
    private String id;
    private Operation.STATUS status;
    private String externalId;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private List<GlebeDTO> glebes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Operation.STATUS getStatus() {
        return status;
    }

    public void setStatus(Operation.STATUS status) {
        this.status = status;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<GlebeDTO> getGlebes() {
        return glebes;
    }

    public void setGlebes(List<GlebeDTO> glebes) {
        this.glebes = glebes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("status", status)
                .append("externalId", externalId)
                .append("description", description)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .append("glebes", glebes)
                .toString();
    }
}