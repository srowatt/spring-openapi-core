package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * This is the root document object of the OpenAPI document.
 */
@JsonDeserialize(builder = OpenApiObject.Builder.class)
public class OpenApiObject extends ExtensibleObject {
    /**
     * This string MUST be the semantic version number of the OpenAPI Specification version that the OpenAPI document
     * uses. The openapi field SHOULD be used by tooling specifications and clients to interpret the OpenAPI document.
     * This is not related to the API info.version string.
     */
    @NotBlank
    private final String openapi;

    /**
     * Provides metadata about the API. The metadata MAY be used by tooling as required.
     */
    @NotNull
    private final InfoObject info;

    /**
     * An array of Server Objects, which provide connectivity information to a target server. If the servers property
     * is not provided, or is an empty array, the default value would be a Server Object with a url value of /.
     */
    private final List<ServerObject> servers;

    /**
     * The available paths and operations for the API.
     */
    @NotNull
    private final PathsObject paths;

    /**
     * An element to hold various schemas for the specification.
     */
    private final ComponentsObject components;

    /**
     * A declaration of which security mechanisms can be used across the API. The list of values includes alternative
     * security requirement objects that can be used. Only one of the security requirement objects need to be satisfied
     * to authorize a request. Individual operations can override this definition.
     */
    private final List<SecurityRequirementObject> security;

    /**
     * A list of tags used by the specification with additional metadata. The order of the tags can be used to reflect
     * on their order by the parsing tools. Not all tags that are used by the Operation Object must be declared. The
     * tags that are not declared MAY be organized randomly or based on the tools' logic. Each tag name in the list
     * MUST be unique.
     */
    private final List<TagObject> tags;

    /**
     * Additional external documentation.
     */
    private final ExternalDocumentationObject externalDocs;

    private OpenApiObject(final String openapi, final InfoObject info, final List<ServerObject> servers,
                          final PathsObject paths, final ComponentsObject components,
                          final List<SecurityRequirementObject> security, final List<TagObject> tags,
                          final ExternalDocumentationObject externalDocs, final Map<String, ?> extensions) {

        super(extensions);

        this.openapi = openapi;
        this.info = info;
        this.servers = servers;
        this.paths = paths;
        this.components = components;
        this.security = security;
        this.tags = tags;
        this.externalDocs = externalDocs;
    }

    public String getOpenapi() {
        return openapi;
    }

    public InfoObject getInfo() {
        return info;
    }

    public List<ServerObject> getServers() {
        return servers;
    }

    public PathsObject getPaths() {
        return paths;
    }

    public ComponentsObject getComponents() {
        return components;
    }

    public List<SecurityRequirementObject> getSecurity() {
        return security;
    }

    public List<TagObject> getTags() {
        return tags;
    }

    public ExternalDocumentationObject getExternalDocs() {
        return externalDocs;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String openapi;
        private InfoObject info;
        private List<ServerObject> servers;
        private PathsObject paths;
        private ComponentsObject components;
        private List<SecurityRequirementObject> security;
        private List<TagObject> tags;
        private ExternalDocumentationObject externalDocs;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withOpenapi(final String openapi) {
            this.openapi = openapi;
            return this;
        }

        public Builder withInfo(final InfoObject info) {
            this.info = info;
            return this;
        }

        public Builder withServers(final List<ServerObject> servers) {
            this.servers = servers;
            return this;
        }

        public Builder withPaths(final PathsObject paths) {
            this.paths = paths;
            return this;
        }

        public Builder withComponents(final ComponentsObject components) {
            this.components = components;
            return this;
        }

        public Builder withSecurity(final List<SecurityRequirementObject> security) {
            this.security = security;
            return this;
        }

        public Builder withTags(final List<TagObject> tags) {
            this.tags = tags;
            return this;
        }

        public Builder withExternalDocs(final ExternalDocumentationObject externalDocs) {
            this.externalDocs = externalDocs;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public OpenApiObject build() {
            return new OpenApiObject(openapi, info, servers, paths, components, security, tags, externalDocs, extensions);
        }
    }
}
