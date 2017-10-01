package com.codineers.springopenapi.core.model;

import java.util.Map;

/**
 * Allows configuration of the supported OAuth Flows.
 */
public class OAuthFlowsObject extends ExtensibleObject {
    /**
     * Configuration for the OAuth Implicit flow
     */
    private final OAuthFlowsObject implicit;

    /**
     * Configuration for the OAuth Resource Owner Password flow
     */
    private final OAuthFlowsObject password;

    /**
     * Configuration for the OAuth Client Credentials flow. Previously called application in OpenAPI 2.0.
     */
    private final OAuthFlowsObject clientCredentials;

    /**
     * Configuration for the OAuth Authorization Code flow. Previously called accessCode in OpenAPI 2.0.
     */
    private final OAuthFlowsObject authorizationCode;


    private OAuthFlowsObject(final OAuthFlowsObject implicit, final OAuthFlowsObject password,
                             final OAuthFlowsObject clientCredentials, final OAuthFlowsObject authorizationCode,
                             final Map<String, ?> extensions) {

        super(extensions);

        this.implicit = implicit;
        this.password = password;
        this.clientCredentials = clientCredentials;
        this.authorizationCode = authorizationCode;
    }

    public OAuthFlowsObject getImplicit() {
        return implicit;
    }

    public OAuthFlowsObject getPassword() {
        return password;
    }

    public OAuthFlowsObject getClientCredentials() {
        return clientCredentials;
    }

    public OAuthFlowsObject getAuthorizationCode() {
        return authorizationCode;
    }

    public static class Builder extends ExtensibleObject.Builder {
        private OAuthFlowsObject implicit;
        private OAuthFlowsObject password;
        private OAuthFlowsObject clientCredentials;
        private OAuthFlowsObject authorizationCode;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withImplicit(OAuthFlowsObject implicit) {
            this.implicit = implicit;
            return this;
        }

        public Builder withPassword(OAuthFlowsObject password) {
            this.password = password;
            return this;
        }

        public Builder withClientCredentials(OAuthFlowsObject clientCredentials) {
            this.clientCredentials = clientCredentials;
            return this;
        }

        public Builder withAuthorizationCode(OAuthFlowsObject authorizationCode) {
            this.authorizationCode = authorizationCode;
            return this;
        }

        public Builder withExtensions(Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public OAuthFlowsObject build() {
            return new OAuthFlowsObject(implicit, password, clientCredentials, authorizationCode, extensions);
        }
    }
}
