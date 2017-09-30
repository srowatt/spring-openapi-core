package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * Adds metadata to a single tag that is used by the Operation Object. It is not mandatory to have a Tag Object per tag
 * defined in the Operation Object instances.
 */
public class TagObject extends ExtensibleObject {

    /**
     * The name of the tag.
     */
    @NotBlank
    private final String name;

    /**
     * A short description for the tag. CommonMark syntax MAY be used for rich text representation.
     */
    private final String description;

    /**
     * Additional external documentation for this tag.
     */
    private final ExternalDocumentationObject externalDocs;

    private TagObject(final String name, final String description, final ExternalDocumentationObject externalDocs,
                     final Map<String, ?> extensions) {

        super(extensions);

        this.name = name;
        this.description = description;
        this.externalDocs = externalDocs;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ExternalDocumentationObject getExternalDocs() {
        return externalDocs;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String name;
        private String description;
        private ExternalDocumentationObject externalDocs;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withExternalDocs(final ExternalDocumentationObject externalDocs) {
            this.externalDocs = externalDocs;
            return this;
        }

        @Override
        public Builder withExtensions(Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public TagObject build() {
            return new TagObject(name, description, externalDocs, extensions);
        }
    }
}
