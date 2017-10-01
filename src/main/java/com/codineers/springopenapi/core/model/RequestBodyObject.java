package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Describes a single request body.
 */
public class RequestBodyObject extends ExtensibleObject {

    /**
     * A brief description of the request body. This could contain examples of use. CommonMark syntax MAY be used for
     * rich text representation.
     */
    private final String description;

    /**
     * The content of the request body. The key is a media type or media type range and the value describes it. For
     * requests that match multiple keys, only the most specific key is applicable. e.g. text/plain overrides text/*
     */
    @NotNull
    private final Map<String, MediaTypeObject> content;

    /**
     * Determines if the request body is required in the request. Defaults to false.
     */
    private final boolean required;

    private RequestBodyObject(final String description, final Map<String, MediaTypeObject> content,
                              final boolean required, final Map<String, ?> extensions) {
        super(extensions);
        this.description = description;
        this.content = content;
        this.required = required;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, MediaTypeObject> getContent() {
        return content;
    }

    public boolean isRequired() {
        return required;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private String description;
        private Map<String, MediaTypeObject> content;
        private boolean required;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withContent(final Map<String, MediaTypeObject> content) {
            this.content = content;
            return this;
        }

        public Builder withRequired(final boolean required) {
            this.required = required;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public RequestBodyObject build() {
            return new RequestBodyObject(description, content, required, extensions);
        }
    }
}
