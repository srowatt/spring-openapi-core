package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class PathItemObject extends ExtensibleObject {
    /**
     * Allows for an external definition of this path item. The referenced structure MUST be in the format of a Path
     * Item Object. If there are conflicts between the referenced definition and this Path Item's definition, the
     * behavior is undefined.
     */
    @JsonProperty("$ref")
    private final String ref;

    /**
     * An optional, string summary, intended to apply to all operations in this path.
     */
    private final String summary;

    /**
     * An optional, string description, intended to apply to all operations in this path. CommonMark syntax MAY be used
     * for rich text representation.
     */
    private final String description;

    /**
     * A definition of a GET operation on this path.
     */
    private final OperationObject get;

    /**
     * A definition of a PUT operation on this path.
     */
    private final OperationObject put;

    /**
     * A definition of a POST operation on this path.
     */
    private final OperationObject post;

    /**
     * A definition of a DELETE operation on this path.
     */
    private final OperationObject delete;

    /**
     * A definition of a OPTIONS operation on this path.
     */
    private final OperationObject options;

    /**
     * A definition of a HEAD operation on this path.
     */
    private final OperationObject head;

    /**
     * A definition of a PATCH operation on this path.
     */
    private final OperationObject patch;

    /**
     * A definition of a TRACE operation on this path.
     */
    private final OperationObject trace;

    /**
     * An alternative server array to service all operations in this path.
     */
    private final List<ServerObject> servers;

    /**
     * A list of parameters that are applicable for all the operations described under this path. These parameters can
     * be overridden at the operation level, but cannot be removed there. The list MUST NOT include duplicated
     * parameters. A unique parameter is defined by a combination of a name and location. The list can use the
     * Reference Object to link to parameters that are defined at the OpenAPI Object's components/parameters.
     */
    private final List<? /*ParameterObject | ReferenceObject*/> parameters;

    private PathItemObject(final String ref, final String summary, final String description, final OperationObject get,
                          final OperationObject put, final OperationObject post, final OperationObject delete,
                          final OperationObject options, final OperationObject head, final OperationObject patch,
                          final OperationObject trace, final List<ServerObject> servers, final List<?> parameters,
                          final Map<String, ?> extensions) {

        super(extensions);

        this.ref = ref;
        this.summary = summary;
        this.description = description;
        this.get = get;
        this.put = put;
        this.post = post;
        this.delete = delete;
        this.options = options;
        this.head = head;
        this.patch = patch;
        this.trace = trace;
        this.servers = servers;
        this.parameters = parameters;
    }

    public String getRef() {
        return ref;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

    public OperationObject getGet() {
        return get;
    }

    public OperationObject getPut() {
        return put;
    }

    public OperationObject getPost() {
        return post;
    }

    public OperationObject getDelete() {
        return delete;
    }

    public OperationObject getOptions() {
        return options;
    }

    public OperationObject getHead() {
        return head;
    }

    public OperationObject getPatch() {
        return patch;
    }

    public OperationObject getTrace() {
        return trace;
    }

    public List<ServerObject> getServers() {
        return servers;
    }

    public List<?> getParameters() {
        return parameters;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private String ref;
        private String summary;
        private String description;
        private OperationObject get;
        private OperationObject put;
        private OperationObject post;
        private OperationObject delete;
        private OperationObject options;
        private OperationObject head;
        private OperationObject patch;
        private OperationObject trace;
        private List<ServerObject> servers;
        private List<? /*ParameterObject | ReferenceObject*/> parameters;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withRef(final String ref) {
            this.ref = ref;
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

        public Builder withGet(final OperationObject get) {
            this.get = get;
            return this;
        }

        public Builder withPut(final OperationObject put) {
            this.put = put;
            return this;
        }

        public Builder withPost(final OperationObject post) {
            this.post = post;
            return this;
        }

        public Builder withDelete(final OperationObject delete) {
            this.delete = delete;
            return this;
        }

        public Builder withOptions(final OperationObject options) {
            this.options = options;
            return this;
        }

        public Builder withHead(final OperationObject head) {
            this.head = head;
            return this;
        }

        public Builder withPatch(final OperationObject patch) {
            this.patch = patch;
            return this;
        }

        public Builder withTrace(final OperationObject trace) {
            this.trace = trace;
            return this;
        }

        public Builder withServers(final List<ServerObject> servers) {
            this.servers = servers;
            return this;
        }

        public Builder withParameters(final List<?> parameters) {
            this.parameters = parameters;
            return this;
        }

        @Override
        public ExtensibleObject.Builder withExtensions(Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public PathItemObject build() {
            return new PathItemObject(ref, summary, description, get, put, post, delete, options, head, patch, trace, servers, parameters, extensions);
        }
    }
}
