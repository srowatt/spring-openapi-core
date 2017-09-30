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
    private String ref;

    /**
     * An optional, string summary, intended to apply to all operations in this path.
     */
    private String summary;

    /**
     * An optional, string description, intended to apply to all operations in this path. CommonMark syntax MAY be used
     * for rich text representation.
     */
    private String description;

    /**
     * A definition of a GET operation on this path.
     */
    private OperationObject get;

    /**
     * A definition of a PUT operation on this path.
     */
    private OperationObject put;

    /**
     * A definition of a POST operation on this path.
     */
    private OperationObject post;

    /**
     * A definition of a DELETE operation on this path.
     */
    private OperationObject delete;

    /**
     * A definition of a OPTIONS operation on this path.
     */
    private OperationObject options;

    /**
     * A definition of a HEAD operation on this path.
     */
    private OperationObject head;

    /**
     * A definition of a PATCH operation on this path.
     */
    private OperationObject patch;

    /**
     * A definition of a TRACE operation on this path.
     */
    private OperationObject trace;

    /**
     * An alternative server array to service all operations in this path.
     */
    private List<ServerObject> servers;

    /**
     * A list of parameters that are applicable for all the operations described under this path. These parameters can
     * be overridden at the operation level, but cannot be removed there. The list MUST NOT include duplicated
     * parameters. A unique parameter is defined by a combination of a name and location. The list can use the
     * Reference Object to link to parameters that are defined at the OpenAPI Object's components/parameters.
     */
    private List<? /*ParameterObject | ReferenceObject*/> parameters;

    public PathItemObject(Map<String, ?> extensions, String ref, String summary, String description, OperationObject get, OperationObject put, OperationObject post, OperationObject delete, OperationObject options, OperationObject head, OperationObject patch, OperationObject trace, List<ServerObject> servers, List<?> parameters) {
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
}
