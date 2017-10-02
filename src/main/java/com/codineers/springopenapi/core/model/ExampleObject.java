package com.codineers.springopenapi.core.model;

import java.util.Map;

public class ExampleObject extends ExtensibleObject {
    /**
     * Short description for the example.
     */
    private final String summary;

    /**
     * Long description for the example. CommonMark syntax MAY be used for rich text representation.
     */
    private final String description;

    /**
     * Embedded literal example. The value field and externalValue field are mutually exclusive. To represent examples
     * of media types that cannot naturally represented in JSON or YAML, use a string value to contain the example,
     * escaping where necessary.
     */
    private final Object/*Any*/ value;

    /**
     * A URL that points to the literal example. This provides the capability to reference examples that cannot easily
     * be included in JSON or YAML documents. The value field and externalValue field are mutually exclusive.
     */
    private final String externalValue;

    private ExampleObject(final String summary, final String description, final Object value,
                          final String externalValue, final Map<String, ?> extensions) {

        super(extensions);

        this.summary = summary;
        this.description = description;
        this.value = value;
        this.externalValue = externalValue;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public Object getValue() {
        return value;
    }

    public String getExternalValue() {
        return externalValue;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private String summary;
        private String description;
        private Object/*Any*/ value;
        private String externalValue;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withSummary(final String summary) {
            this.summary = summary;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withValue(final Object value) {
            this.value = value;
            return this;
        }

        public Builder withExternalValue(final String externalValue) {
            this.externalValue = externalValue;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public ExampleObject build() {
            return new ExampleObject(summary, description, value, externalValue, extensions);
        }
    }
}
