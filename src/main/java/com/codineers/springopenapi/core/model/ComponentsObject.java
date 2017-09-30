package com.codineers.springopenapi.core.model;

import java.util.Map;

/**
 * Holds a set of reusable objects for different aspects of the OAS. All objects defined within the components object
 * will have no effect on the API unless they are explicitly referenced from properties outside the components object.
 */
public class ComponentsObject extends ExtensibleObject {
    /**
     * An object to hold reusable Schema Objects.
     */
    private final Map<String, ? /*SchemaObject | ReferenceObject*/> schemas;

    /**
     * An object to hold reusable Response Objects.
     */
    private final Map<String, ? /*ResponseObject | ReferenceObject*/> responses;

    /**
     * An object to hold reusable Parameter Objects.
     */
    private final Map<String, ? /*ParameterObject | ReferenceObject*/> parameters;

    /**
     * An object to hold reusable Example Objects.
     */
    private final Map<String, ? /*ExampleObject | ReferenceObject*/> examples;

    /**
     * An object to hold reusable Request Body Objects.
     */
    private final Map<String, ? /*RequestBodyObject | ReferenceObject*/> requestBodies;

    /**
     * An object to hold reusable Header Objects.
     */
    private final Map<String, ? /*HeaderObject | ReferenceObject*/> headers;

    /**
     * An object to hold reusable Security Scheme Objects.
     */
    private final Map<String, ? /*SecuritySchemeObject | ReferenceObject*/> securitySchemes;

    /**
     * An object to hold reusable Link Objects.
     */
    private final Map<String, ? /*LinkObject | ReferenceObject*/> links;

    /**
     * An object to hold reusable Callback Objects.
     */
    private final Map<String, ? /*CallbackObject | ReferenceObject*/> callbacks;

    private ComponentsObject(final Map<String, ?> schemas, final Map<String, ?> responses,
                            final Map<String, ?> parameters, final Map<String, ?> examples,
                            final Map<String, ?> requestBodies, final Map<String, ?> headers,
                            final Map<String, ?> securitySchemes, final Map<String, ?> links,
                            final Map<String, ?> callbacks, final Map<String, ?> extensions) {

        super(extensions);

        this.schemas = schemas;
        this.responses = responses;
        this.parameters = parameters;
        this.examples = examples;
        this.requestBodies = requestBodies;
        this.headers = headers;
        this.securitySchemes = securitySchemes;
        this.links = links;
        this.callbacks = callbacks;
    }

    public Map<String, ?> getSchemas() {
        return schemas;
    }

    public Map<String, ?> getResponses() {
        return responses;
    }

    public Map<String, ?> getParameters() {
        return parameters;
    }

    public Map<String, ?> getExamples() {
        return examples;
    }

    public Map<String, ?> getRequestBodies() {
        return requestBodies;
    }

    public Map<String, ?> getHeaders() {
        return headers;
    }

    public Map<String, ?> getSecuritySchemes() {
        return securitySchemes;
    }

    public Map<String, ?> getLinks() {
        return links;
    }

    public Map<String, ?> getCallbacks() {
        return callbacks;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private Map<String, ? /*SchemaObject | ReferenceObject*/> schemas;
        private Map<String, ? /*ResponseObject | ReferenceObject*/> responses;
        private Map<String, ? /*ParameterObject | ReferenceObject*/> parameters;
        private Map<String, ? /*ExampleObject | ReferenceObject*/> examples;
        private Map<String, ? /*RequestBodyObject | ReferenceObject*/> requestBodies;
        private Map<String, ? /*HeaderObject | ReferenceObject*/> headers;
        private Map<String, ? /*SecuritySchemeObject | ReferenceObject*/> securitySchemes;
        private Map<String, ? /*LinkObject | ReferenceObject*/> links;
        private Map<String, ? /*CallbackObject | ReferenceObject*/> callbacks;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withSchemas(final Map<String, ? /*SchemaObject | ReferenceObject*/> schemas) {
            this.schemas = schemas;
            return this;
        }

        public Builder withResponses(final Map<String, ? /*ResponseObject | ReferenceObject*/> responses) {
            this.responses = responses;
            return this;
        }

        public Builder withparameters(final Map<String, ? /*ParameterObject | ReferenceObject*/> parameters) {
            this.parameters = parameters;
            return this;
        }

        public Builder withExamples(final Map<String, ? /*ExampleObject | ReferenceObject*/> examples) {
            this.examples = examples;
            return this;
        }

        public Builder withRequestBodies(final Map<String, ? /*RequestBodyObject | ReferenceObject*/> requestBodies) {
            this.requestBodies = requestBodies;
            return this;
        }

        public Builder withHeaders(final Map<String, ? /*HeaderObject | ReferenceObject*/> headers) {
            this.headers = headers;
            return this;
        }

        public Builder withSecuritySchemes(final Map<String, ? /*SecuritySchemeObject | ReferenceObject*/> securitySchemes) {
            this.securitySchemes = securitySchemes;
            return this;
        }

        public Builder withLinks(final Map<String, ? /*LinkObject | ReferenceObject*/> links) {
            this.links = links;
            return this;
        }

        public Builder withCallbacks(final Map<String, ? /*CallbackObject | ReferenceObject*/> callbacks) {
            this.callbacks = callbacks;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public ComponentsObject build() {
            return new ComponentsObject(schemas, responses, parameters, examples, requestBodies, headers,
                    securitySchemes, links, callbacks, extensions);
        }
    }
}
