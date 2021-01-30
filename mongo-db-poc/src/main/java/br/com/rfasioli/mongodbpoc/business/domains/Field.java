package br.com.rfasioli.mongodbpoc.business.domains;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.geo.Polygon;

import java.time.LocalDateTime;
import java.util.List;

public class Field {

    public static enum STATUS {
        PENDING,
        PROCESSING,
        CANCELLED,
        DONE
    }

    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private STATUS status;
    private Polygon geometry;
    private List<Mosaic> mosaics;

    public Field() {
    }

    private Field(Builder builder) {
        id = builder.id;
        createdAt = builder.createdAt;
        modifiedAt = builder.modifiedAt;
        status = builder.status;
        geometry = builder.geometry;
        mosaics = builder.mosaics;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Field copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.createdAt = copy.getCreatedAt();
        builder.modifiedAt = copy.getModifiedAt();
        builder.status = copy.getStatus();
        builder.geometry = copy.getGeometry();
        builder.mosaics = copy.getMosaics();
        return builder;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public Polygon getGeometry() {
        return geometry;
    }

    public STATUS getStatus() {
        return status;
    }

    public List<Mosaic> getMosaics() {
        return mosaics;
    }

    public boolean equals(Object object) {
        if (this == object) return true;

        if (object == null || getClass() != object.getClass()) return false;

        Field field = (Field) object;

        return new EqualsBuilder()
                .appendSuper(super.equals(object))
                .append(id, field.id)
                .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
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

    public static final class Builder {
        private String id;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;
        private STATUS status;
        private Polygon geometry;
        private List<Mosaic> mosaics;

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

        public Builder withGeometry(Polygon val) {
            geometry = val;
            return this;
        }

        public Builder withMosaics(List<Mosaic> val) {
            mosaics = val;
            return this;
        }

        public Field build() {
            return new Field(this);
        }
    }
}