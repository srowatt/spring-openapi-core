package com.codineers.springopenapi.core.model;

import java.util.Map;

/**
 * The Link object represents a possible design-time link for a response. The presence of a link does not guarantee the
 * caller's ability to successfully invoke it, rather it provides a known relationship and traversal mechanism between
 * responses and other operations.
 *
 * Unlike dynamic links (i.e. links provided in the response payload), the OAS linking mechanism does not require link
 * information in the runtime response.
 *
 * For computing links, and providing instructions to execute them, a runtime expression is used for accessing values
 * in an operation and using them as parameters while invoking the linked operation.
 *
 * A linked operation MUST be identified using either an operationRef or operationId. In the case of an operationId, it
 * MUST be unique and resolved in the scope of the OAS document. Because of the potential for name clashes, the
 * operationRef syntax is preferred for specifications with external references.
 */
public class LinkObject extends ExtensibleObject {
    /**
     * A relative or absolute reference to an OAS operation. This field is mutually exclusive of the operationId field,
     * and MUST point to an Operation Object. Relative operationRef values MAY be used to locate an existing Operation
     * Object in the OpenAPI definition.
     */
    private final String operationRef;

    /**
     * The name of an existing, resolvable OAS operation, as defined with a unique operationId. This field is mutually
     * exclusive of the operationRef field.
     */
    private final String operationId;

    /**
     * A map representing parameters to pass to an operation as specified with operationId or identified via
     * operationRef. The key is the parameter name to be used, whereas the value can be a constant or an expression to
     * be evaluated and passed to the linked operation. The parameter name can be qualified using the parameter
     * location [{in}.]{name} for operations that use the same parameter name in different locations (e.g. path.id).
     */
    private final Map<String, ? /*Any | {expression}*/> parameters;

    /**
     * A literal value or {expression} to use as a request body when calling the target operation.
     */
    private final Object /*Any | {expression}*/ requestBody;

    /**
     * A description of the link. CommonMark syntax MAY be used for rich text representation.
     */
    private final String description;

    /**
     * A server object to be used by the target operation.
     */
    private final ServerObject server;

    private LinkObject(final String operationRef, final String operationId, final Map<String, ?> parameters,
                      final Object requestBody, final String description, final ServerObject server,
                      final Map<String, ?> extensions) {

        super(extensions);

        this.operationRef = operationRef;
        this.operationId = operationId;
        this.parameters = parameters;
        this.requestBody = requestBody;
        this.description = description;
        this.server = server;
    }

    public String getOperationRef() {
        return operationRef;
    }

    public String getOperationId() {
        return operationId;
    }

    public Map<String, ?> getParameters() {
        return parameters;
    }

    public Object getRequestBody() {
        return requestBody;
    }

    public String getDescription() {
        return description;
    }

    public ServerObject getServer() {
        return server;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private String operationRef;
        private String operationId;
        private Map<String, ? /*Any | {expression}*/> parameters;
        private Object /*Any | {expression}*/ requestBody;
        private String description;
        private ServerObject server;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withOperationRef(final String operationRef) {
            this.operationRef = operationRef;
            return this;
        }

        public Builder withOperationId(final String operationId) {
            this.operationId = operationId;
            return this;
        }

        public Builder withParameters(final Map<String, ?> parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder withRequestBody(final Object requestBody) {
            this.requestBody = requestBody;
            return this;
        }

        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public Builder withServer(final ServerObject server) {
            this.server = server;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public LinkObject build() {
            return new LinkObject(operationRef, operationId, parameters, requestBody, description, server, extensions);
        }
    }
}
