package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * An object representing a Server Variable for server URL template substitution.
 */
public class ServerVariableObject extends ExtensibleObject {
    /**
     * An enumeration of string values to be used if the substitution options are from a limited set.
     */
    @JsonProperty("enum")
    private final List<String> enumeration;

    /**
     * The default value to use for substitution, and to send, if an alternate value is not supplied. Unlike the Schema Object's default, this value MUST be provided by the consumer.
     */
    @NotBlank
    @JsonProperty("default")
    private final String defaultValue;

    /**
     * An optional description for the server variable. CommonMark syntax MAY be used for rich text representation.
     */
    private final String description;

    private ServerVariableObject(final List<String> enumeration, final String defaultValue, final String description,
                                 final Map<String, ?> extensions) {

        super(extensions);

        this.enumeration = enumeration;
        this.defaultValue = defaultValue;
        this.description = description;
    }

    public List<String> getEnumeration() {
        return enumeration;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private List<String> enumeration;
        private String defaultValue;
        private String description;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withEnumeration(final List<String> enumeration) {
            this.enumeration = enumeration;
            return this;
        }

        public Builder withDefaultValue(final String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        @Override
        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public ServerVariableObject build() {
            return new ServerVariableObject(enumeration, defaultValue, description, extensions);
        }
    }
}
