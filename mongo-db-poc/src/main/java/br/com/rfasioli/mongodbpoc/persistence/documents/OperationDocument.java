package br.com.rfasioli.mongodbpoc.persistence.documents;

import br.com.rfasioli.mongodbpoc.business.domains.Operation;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection="Operation")
public class OperationDocument {
    @Id
    private String id;

    @Indexed
    private Operation.STATUS status;

    @Indexed(unique = true)
    private String externalId;

    private String description;

    @Indexed
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    private List<GlebeDocument> glebes;

    public OperationDocument() {
    }

    public OperationDocument(String id,
                             Operation.STATUS status,
                             String externalId,
                             String description,
                             LocalDateTime createdAt,
                             LocalDateTime modifiedAt,
                             List<GlebeDocument> glebes) {
        this.id = id;
        this.status = status;
        this.externalId = externalId;
        this.description = description;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.glebes = glebes;
    }

    public static OperationDocument of(String id,
                                       Operation.STATUS status,
                                       String externalId,
                                       String description,
                                       LocalDateTime createdAt,
                                       LocalDateTime modifiedAt,
                                       List<GlebeDocument> glebes) {
        return new OperationDocument(id,
                status,
                externalId,
                description,
                createdAt,
                modifiedAt,
                glebes);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<GlebeDocument> getGlebes() {
        return glebes;
    }

    public void setGlebes(List<GlebeDocument> glebes) {
        this.glebes = glebes;
    }

    public Operation.STATUS getStatus() {
        return status;
    }

    public void setStatus(Operation.STATUS status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        OperationDocument that = (OperationDocument) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(externalId, that.externalId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(externalId)
                .toHashCode();
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