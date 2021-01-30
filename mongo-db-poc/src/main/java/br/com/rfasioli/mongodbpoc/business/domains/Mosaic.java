package br.com.rfasioli.mongodbpoc.business.domains;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mosaic implements Serializable {

    public static enum STATUS {
        PROCESSING,
        FAILED,
        DONE
    }

    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private STATUS status;
    private String description;
    private String rawImageReference;
    private String NDVIRawImageReference;
    private String visualImageReference;
    private String NDVIVisualImageReference;

    public Mosaic() {
    }

    private Mosaic(Builder builder) {
        id = builder.id;
        createdAt = builder.createdAt;
        modifiedAt = builder.modifiedAt;
        status = builder.status;
        description = builder.description;
        rawImageReference = builder.rawImageReference;
        NDVIRawImageReference = builder.NDVIRawImageReference;
        visualImageReference = builder.visualImageReference;
        NDVIVisualImageReference = builder.NDVIVisualImageReference;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Mosaic copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.createdAt = copy.getCreatedAt();
        builder.modifiedAt = copy.getModifiedAt();
        builder.status = copy.getStatus();
        builder.description = copy.getDescription();
        builder.rawImageReference = copy.getRawImageReference();
        builder.NDVIRawImageReference = copy.getNDVIRawImageReference();
        builder.visualImageReference = copy.getVisualImageReference();
        builder.NDVIVisualImageReference = copy.getNDVIVisualImageReference();
        return builder;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getRawImageReference() {
        return rawImageReference;
    }

    public String getNDVIRawImageReference() {
        return NDVIRawImageReference;
    }

    public String getVisualImageReference() {
        return visualImageReference;
    }

    public String getNDVIVisualImageReference() {
        return NDVIVisualImageReference;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public STATUS getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Mosaic mosaic = (Mosaic) o;

        return new EqualsBuilder()
                .append(id, mosaic.id)
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

    public static final class Builder {
        private String id;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private STATUS status;
        private String description;
        private String rawImageReference;
        private String NDVIRawImageReference;
        private String visualImageReference;
        private String NDVIVisualImageReference;

        private Builder() {
        }

        public Builder withId(String val) {
            id = val;
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

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withRawImageReference(String val) {
            rawImageReference = val;
            return this;
        }

        public Builder withNDVIRawImageReference(String val) {
            NDVIRawImageReference = val;
            return this;
        }

        public Builder withVisualImageReference(String val) {
            visualImageReference = val;
            return this;
        }

        public Builder withNDVIVisualImageReference(String val) {
            NDVIVisualImageReference = val;
            return this;
        }

        public Mosaic build() {
            return new Mosaic(this);
        }
    }
}
