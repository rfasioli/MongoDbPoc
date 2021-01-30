package br.com.rfasioli.mongodbpoc.business.domains;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;
import java.util.List;

public class Operation {

    public static enum STATUS {
        PENDING,
        CANCELLED,
        DONE
    }

    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private STATUS status;
    private String externalId;
    private String description;
    private List<Glebe> glebes;

    public Operation() {
    }

    private Operation(Builder builder) {
        id = builder.id;
        createdAt = builder.createdAt;
        modifiedAt = builder.modifiedAt;
        status = builder.status;
        externalId = builder.externalId;
        description = builder.description;
        glebes = builder.glebes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Operation copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.createdAt = copy.getCreatedAt();
        builder.modifiedAt = copy.getModifiedAt();
        builder.status = copy.getStatus();
        builder.externalId = copy.getExternalId();
        builder.description = copy.getDescription();
        builder.glebes = copy.getGlebes();
        return builder;
    }

    public String getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public List<Glebe> getGlebes() {
        return glebes;
    }

    public STATUS getStatus() {
        return status;
    }

    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        Operation operation = (Operation) object;

        return new EqualsBuilder()
                .appendSuper(super.equals(object))
                .append(id, operation.id)
                .append(externalId, operation.externalId)
                .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(id)
                .append(externalId)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("createdAt", createdAt)
                .append("modifiedAt", modifiedAt)
                .append("status", status)
                .append("externalId", externalId)
                .append("description", description)
                .append("glebes", glebes)
                .toString();
    }

    public static final class Builder {
        private String id;
        private String externalId;
        private String description;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private STATUS status;
        private List<Glebe> glebes;

        private Builder() {
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withExternalId(String val) {
            externalId = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withCreatedAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder withModifiedAt(LocalDateTime val) {
            modifiedAt = val;
            return this;
        }

        public Builder withStatus(STATUS val) {
            status = val;
            return this;
        }

        public Builder withGlebes(List<Glebe> val) {
            glebes = val;
            return this;
        }

        public Operation build() {
            return new Operation(this);
        }
    }

}