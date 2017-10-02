package com.codineers.springopenapi.core.model;

import java.util.Map;

/**
 * A map of possible out-of band callbacks related to the parent operation. Each value in the map is a Path Item Object
 * that describes a set of requests that may be initiated by the API provider and the expected responses. The key value
 * used to identify the callback object is an expression, evaluated at runtime, that identifies a URL to use for the
 * callback operation.
 * <p>
 * TODO: The key is a string representing an expression so need to find a way to json serialise it
 * https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.0.md#callback-object
 */
public class CallbackObject extends ExtensibleObject {
    /**
     * A Path Item Object used to define a callback request and expected responses. A complete example is available.
     */
    private final PathItemObject expression;

    private CallbackObject(final PathItemObject expression, final Map<String, ?> extensions) {
        super(extensions);
        this.expression = expression;
    }

    public PathItemObject getExpression() {
        return expression;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private PathItemObject expression;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withExpression(final PathItemObject expression) {
            this.expression = expression;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public CallbackObject build() {
            return new CallbackObject(expression, extensions);
        }
    }
}
