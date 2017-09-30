package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

/**
 * A simple object to allow referencing other components in the specification, internally and externally.
 *
 * The Reference Object is defined by JSON Reference and follows the same structure, behavior and rules.
 *
 * For this specification, reference resolution is accomplished as defined by the JSON Reference specification and not
 * by the JSON Schema specification.
 */
public class ReferenceObject implements IReferenceObject {
    /**
     * The reference string.
     */
    @JsonProperty("$ref")
    @NotBlank
    private String ref;

    @Override
    public String getRef() {
        return ref;
    }
}
