package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * Allows referencing an external resource for extended documentation.
 */
@JsonDeserialize(builder = ExternalDocumentationObject.Builder.class)
public class ExternalDocumentationObject extends ExtensibleObject {
    /**
     * A short description of the target documentation. CommonMark syntax MAY be used for rich text representation.
     */
    private final String description;

    /**
     * The URL for the target documentation. Value MUST be in the format of a URL.
     */
    @NotBlank
    private final String url;

    private ExternalDocumentationObject(final String description, final String url, final Map<String, ?> extensions) {

        super(extensions);

        this.description = description;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String description;
        private String url;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withUrl(final String url) {
            this.url = url;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public ExternalDocumentationObject build() {
            return new ExternalDocumentationObject(description, url, extensions);
        }
    }
}
