package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * Describes a single response from an API Operation, including design-time, static links to operations based on the response.
 */
public class ResponseObject extends ExtensibleObject {
    /**
     * A short description of the response. CommonMark syntax MAY be used for rich text representation.
     */
    @NotBlank
    private final String description;

    /**
     * Maps a header name to its definition. RFC7230 states header names are case insensitive. If a response header is
     * defined with the name "Content-Type", it SHALL be ignored.
     */
    private final Map<String, ? /*HeaderObject | ReferenceObject*/> headers;

    /**
     * A map containing descriptions of potential response payloads. The key is a media type or media type range and
     * the value describes it. For responses that match multiple keys, only the most specific key is applicable.
     * e.g. text/plain overrides text/*
     */
    private final Map<String, MediaTypeObject> content;

    /**
     * A map of operations links that can be followed from the response.
     * <p>
     * The key of the map is a short name for the link, following the naming constraints of the names for Component Objects.
     */
    private final Map<String, ? /*LinkObject | ReferenceObject*/> links;

    private ResponseObject(final String description, final Map<String, ?> headers,
                           final Map<String, MediaTypeObject> content, final Map<String, ?> links,
                           final Map<String, ?> extensions) {

        super(extensions);

        this.description = description;
        this.headers = headers;
        this.content = content;
        this.links = links;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, ?> getHeaders() {
        return headers;
    }

    public Map<String, MediaTypeObject> getContent() {
        return content;
    }

    public Map<String, ?> getLinks() {
        return links;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private String description;
        private Map<String, ? /*HeaderObject | ReferenceObject*/> headers;
        private Map<String, MediaTypeObject> content;
        private Map<String, ? /*LinkObject | ReferenceObject*/> links;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withHeaders(final Map<String, ?> headers) {
            this.headers = headers;
            return this;
        }

        public Builder withContent(final Map<String, MediaTypeObject> content) {
            this.content = content;
            return this;
        }

        public Builder withLinks(final Map<String, ?> links) {
            this.links = links;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public ResponseObject build() {
            return new ResponseObject(description, headers, content, links, extensions);
        }
    }
}
