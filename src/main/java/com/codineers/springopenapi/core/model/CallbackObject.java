package com.codineers.springopenapi.core.model;

import java.util.Map;

/**
 * A map of possible out-of band callbacks related to the parent operation. Each value in the map is a Path Item Object
 * that describes a set of requests that may be initiated by the API provider and the expected responses. The key value
 * used to identify the callback object is an expression, evaluated at runtime, that identifies a URL to use for the
 * callback operation.
 *
 * TODO: The key is a string representing an expression so need to find a way to json serialise it
 * https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md#callback-object
 */
public class CallbackObject extends ExtensibleObject {
    /**
     * A Path Item Object used to define a callback request and expected responses. A complete example is available.
     */
    private PathItemObject expression;

    public CallbackObject(Map<String, ?> extensions, PathItemObject expression) {
        super(extensions);
        this.expression = expression;
    }
}
