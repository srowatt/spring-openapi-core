package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * When request bodies or response payloads may be one of a number of different schemas, a discriminator object can be
 * used to aid in serialization, deserialization, and validation. The discriminator is a specific object in a schema
 * which is used to inform the consumer of the specification of an alternative schema based on the value associated
 * with it.
 *
 * When using the discriminator, inline schemas will not be considered.
 */
public class DiscriminatorObject {
    /**
     * The name of the property in the payload that will hold the discriminator value.
     */
    @NotBlank
    private final String propertyName;

    /**
     * An object to hold mappings between payload values and schema names or references.
     */
    private final Map<String, String> mapping;

    private DiscriminatorObject(final String propertyName, final Map<String, String> mapping) {
        this.propertyName = propertyName;
        this.mapping = mapping;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Map<String, String> getMapping() {
        return mapping;
    }

    public static class Builder {
        private String propertyName;
        private Map<String, String> mapping;

        public Builder builder() {
            return new Builder();
        }

        public Builder withPropertyName(final String propertyName) {
            this.propertyName = propertyName;
            return this;
        }

        public Builder withMapping(final Map<String, String> mapping) {
            this.mapping = mapping;
            return this;
        }

        public DiscriminatorObject build() {
            return new DiscriminatorObject(propertyName, mapping);
        }
    }
}
