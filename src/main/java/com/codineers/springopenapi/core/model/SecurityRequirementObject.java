package com.codineers.springopenapi.core.model;

import java.util.List;

/**
 * Lists the required security schemes to execute this operation. The name used for each property MUST correspond to a
 * security scheme declared in the Security Schemes under the Components Object.
 *
 * Security Requirement Objects that contain multiple schemes require that all schemes MUST be satisfied for a request
 * to be authorized. This enables support for scenarios where multiple query parameters or HTTP headers are required to
 * convey security information.
 *
 * When a list of Security Requirement Objects is defined on the Open API object or Operation Object, only one of
 * Security Requirement Objects in the list needs to be satisfied to authorize the request.
 */
public class SecurityRequirementObject {

    /**
     * Each name MUST correspond to a security scheme which is declared in the Security Schemes under the Components
     * Object. If the security scheme is of type "oauth2" or "openIdConnect", then the value is a list of scope names
     * required for the execution. For other security scheme types, the array MUST be empty.
     */
    private List<String> name;

    public SecurityRequirementObject(List<String> name) {
        this.name = name;
    }

    public List<String> getName() {
        return name;
    }

    public static final class Builder {
        private List<String> name;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withName(List<String> name) {
            this.name = name;
            return this;
        }

        public SecurityRequirementObject build() {
            return new SecurityRequirementObject(name);
        }
    }
}
