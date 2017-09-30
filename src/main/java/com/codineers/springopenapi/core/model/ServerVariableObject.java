package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ServerVariableObject {
    /**
     * An enumeration of string values to be used if the substitution options are from a limited set.
     */
    @JsonProperty("enum")
    private List<String> enumeration;

    /**
     * The default value to use for substitution, and to send, if an alternate value is not supplied. Unlike the Schema Object's default, this value MUST be provided by the consumer.
     */
    @NotBlank
    @JsonProperty("default")
    private String defaultValue;

    /**
     * 	An optional description for the server variable. CommonMark syntax MAY be used for rich text representation.
     */
    private String description;
}
