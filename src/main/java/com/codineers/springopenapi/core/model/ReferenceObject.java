package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

/**
 * A simple object to allow referencing other components in the specification, internally and externally.
 * <p>
 * The Reference Object is defined by JSON Reference and follows the same structure, behavior and rules.
 * <p>
 * For this specification, reference resolution is accomplished as defined by the JSON Reference specification and not
 * by the JSON Schema specification.
 */
public class ReferenceObject {
    /**
     * The reference string.
     */
    @JsonProperty("$ref")
    @NotBlank
    private final String ref;

    private ReferenceObject(@NotBlank String ref) {
        this.ref = ref;
    }

    public String getRef() {
        return ref;
    }

    public static class Builder {
        private String ref;

        public Builder builder() {
            return new Builder();
        }

        public Builder withRef(final String ref) {
            this.ref = ref;
            return this;
        }

        public ReferenceObject build() {
            return new ReferenceObject(ref);
        }
    }
}
