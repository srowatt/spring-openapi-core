package com.codineers.springopenapi.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * A container for the expected responses of an operation. The container maps a HTTP response code to the expected response.
 * <p>
 * The documentation is not necessarily expected to cover all possible HTTP response codes because they may not be known
 * in advance. However, documentation is expected to cover a successful operation response and any known errors.
 * <p>
 * The default MAY be used as a default response object for all HTTP codes that are not covered individually by the specification.
 * <p>
 * The Responses Object MUST contain at least one response code, and it SHOULD be the response for a successful operation call.
 */
public class ResponsesObject extends ExtensibleObject {
    /**
     * The documentation of responses other than the ones declared for specific HTTP response codes. Use this field to
     * cover undeclared responses. A Reference Object can link to a response that the OpenAPI Object's
     * components/responses section defines.
     */
    @JsonProperty("default")
    private final Object/*ResponseObject | ReferenceObject*/ defaultResponse;

    /**
     * Any HTTP status code can be used as the property name, but only one property per code, to describe the expected
     * response for that HTTP status code. A Reference Object can link to a response that is defined in the OpenAPI
     * Object's components/responses section. This field MUST be enclosed in quotation marks (for example, "200") for
     * compatibility between JSON and YAML. To define a range of response codes, this field MAY contain the uppercase
     * wildcard character X. For example, 2XX represents all response codes between [200-299]. The following range
     * definitions are allowed: 1XX, 2XX, 3XX, 4XX, and 5XX. If a response range is defined using an explicit code, the
     * explicit code definition takes precedence over the range definition for that code.
     */
    private final Map<String, ?/*Response Object | Reference Object*/> httpStatusCode;

    private ResponsesObject(final Object defaultResponse, final Map<String, ?> httpStatusCode, final Map<String, ?> extensions) {
        super(extensions);
        this.defaultResponse = defaultResponse;
        this.httpStatusCode = httpStatusCode;
    }

    public Object getDefaultResponse() {
        return defaultResponse;
    }

    public Map<String, ?> getHttpStatusCode() {
        return httpStatusCode;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private Object/*ResponseObject | ReferenceObject*/ defaultResponse;
        private Map<String, ?/*Response Object | Reference Object*/> httpStatusCode;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withDefaultResponse(ResponseObject responseObject) {
            this.defaultResponse = responseObject;
            return this;
        }

        public Builder withDefaultResponse(ReferenceObject referenceObject) {
            this.defaultResponse = referenceObject;
            return this;
        }

        public Builder withHttpStatusCode(Map<String, ?> httpStatusCode) {
            this.httpStatusCode = httpStatusCode;
            return this;
        }

        public Builder withExtensions(Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public ResponsesObject build() {
            return new ResponsesObject(defaultResponse, httpStatusCode, extensions);
        }
    }
}
