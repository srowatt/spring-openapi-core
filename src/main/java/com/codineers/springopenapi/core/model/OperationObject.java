package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Describes a single API operation on a path.
 */
public class OperationObject extends ExtensibleObject {

    /**
     * A list of tags for API documentation control. Tags can be used for logical grouping of operations by resources
     * or any other qualifier.
     */
    private final List<String> tags;

    /**
     * A short summary of what the operation does.
     */
    private final String summary;

    /**
     * A verbose explanation of the operation behavior. CommonMark syntax MAY be used for rich text representation.
     */
    private final String description;

    /**
     * Additional external documentation for this operation.
     */
    private final ExternalDocumentationObject externalDocs;

    /**
     * Unique string used to identify the operation. The id MUST be unique among all operations described in the API.
     * Tools and libraries MAY use the operationId to uniquely identify an operation, therefore, it is RECOMMENDED to
     * follow common programming naming conventions.
     */
    private final String operationId;

    /**
     * A list of parameters that are applicable for this operation. If a parameter is already defined at the Path Item,
     * the new definition will override it but can never remove it. The list MUST NOT include duplicated parameters.
     * A unique parameter is defined by a combination of a name and location. The list can use the Reference Object to
     * link to parameters that are defined at the OpenAPI Object's components/parameters.
     */
    private final List<? /*ParameterObject | ReferenceObject*/> parameters;

    /**
     * The request body applicable for this operation. The requestBody is only supported in HTTP methods where the
     * HTTP 1.1 specification RFC7231 has explicitly defined semantics for request bodies. In other cases where the
     * HTTP spec is vague, requestBody SHALL be ignored by consumers.
     */
    private final Object/*RequestBodyObject | ReferenceObject*/ requestBody;

    /**
     * The list of possible responses as they are returned from executing this operation.
     */
    @NotNull
    private final ResponsesObject responses;

    /**
     * A map of possible out-of band callbacks related to the parent operation. The key is a unique identifier for the
     * Callback Object. Each value in the map is a Callback Object that describes a request that may be initiated by
     * the API provider and the expected responses. The key value used to identify the callback object is an expression,
     * evaluated at runtime, that identifies a URL to use for the callback operation.
     */
    private final Map<String, ?/*Callback Object | Reference Object*/> callbacks;

    /**
     * Declares this operation to be deprecated. Consumers SHOULD refrain from usage of the declared operation.
     * Default value is false.
     */
    private final boolean deprecated;

    /**
     * A declaration of which security mechanisms can be used for this operation. The list of values includes
     * alternative security requirement objects that can be used. Only one of the security requirement objects need to
     * be satisfied to authorize a request. This definition overrides any declared top-level security. To remove a
     * top-level security declaration, an empty array can be used.
     */
    private final List<SecurityRequirementObject> security;

    /**
     * An alternative server array to service this operation. If an alternative server object is specified at the Path
     * Item Object or Root level, it will be overridden by this value.
     */
    private final List<ServerObject> servers;

    public OperationObject(final List<String> tags, final String summary, final String description,
                           final ExternalDocumentationObject externalDocs, final String operationId,
                           final List<?> parameters, final Object requestBody, final ResponsesObject responses,
                           final Map<String, ?> callbacks, final boolean deprecated,
                           final List<SecurityRequirementObject> security, final List<ServerObject> servers,
                           final Map<String, ?> extensions) {
        super(extensions);
        this.tags = tags;
        this.summary = summary;
        this.description = description;
        this.externalDocs = externalDocs;
        this.operationId = operationId;
        this.parameters = parameters;
        this.requestBody = requestBody;
        this.responses = responses;
        this.callbacks = callbacks;
        this.deprecated = deprecated;
        this.security = security;
        this.servers = servers;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public ExternalDocumentationObject getExternalDocs() {
        return externalDocs;
    }

    public String getOperationId() {
        return operationId;
    }

    public List<?> getParameters() {
        return parameters;
    }

    public Object getRequestBody() {
        return requestBody;
    }

    public ResponsesObject getResponses() {
        return responses;
    }

    public Map<String, ?> getCallbacks() {
        return callbacks;
    }

    public boolean isDeprecated() {
        return deprecated;
    }

    public List<SecurityRequirementObject> getSecurity() {
        return security;
    }

    public List<ServerObject> getServers() {
        return servers;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private List<String> tags;
        private String summary;
        private String description;
        private ExternalDocumentationObject externalDocs;
        private String operationId;
        private List<? /*ParameterObject | ReferenceObject*/> parameters;
        private Object/*RequestBodyObject | ReferenceObject*/ requestBody;
        private ResponsesObject responses;
        private Map<String, ?/*Callback Object | Reference Object*/> callbacks;
        private boolean deprecated;
        private List<SecurityRequirementObject> security;
        private List<ServerObject> servers;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withTags(final List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder withSummary(final String summary) {
            this.summary = summary;
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

        public Builder withOperationId(final String operationId) {
            this.operationId = operationId;
            return this;
        }

        public Builder withParameters(final List<?> parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder withRequestBody(final Object requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public Builder withResponses(final ResponsesObject responses) {
            this.responses = responses;
            return this;
        }

        public Builder withCallbacks(final Map<String, ?> callbacks) {
            this.callbacks = callbacks;
            return this;
        }

        public Builder withDeprecated(final boolean deprecated) {
            this.deprecated = deprecated;
            return this;
        }

        public Builder withSecurity(final List<SecurityRequirementObject> security) {
            this.security = security;
            return this;
        }

        public Builder withServers(final List<ServerObject> servers) {
            this.servers = servers;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public OperationObject build() {
            return new OperationObject(tags, summary, description, externalDocs, operationId, parameters, requestBody,
                    responses, callbacks, deprecated, security, servers, extensions);
        }
    }
}
