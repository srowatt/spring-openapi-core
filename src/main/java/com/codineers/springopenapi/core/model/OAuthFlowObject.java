package com.codineers.springopenapi.core.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Configuration details for a supported OAuth Flow
 */
public class OAuthFlowObject extends ExtensibleObject {
    /**
     * The authorization URL to be used for this flow. This MUST be in the form of a URL.
     *
     * Applies to: oauth2 ("implicit", "authorizationCode")
     */
    @NotBlank
    private final String authorizationUrl;

    /**
     * The token URL to be used for this flow. This MUST be in the form of a URL.
     *
     * Applies to: oauth2 ("password", "clientCredentials", "authorizationCode")
     */
    @NotBlank
    private final String tokenUrl;

    /**
     * The URL to be used for obtaining refresh tokens. This MUST be in the form of a URL.
     *
     * Applies to: oauth2
     */
    private final String refreshUrl;

    /**
     * The available scopes for the OAuth2 security scheme. A map between the scope name and a short description for it.
     *
     * Applies to: oauth2
     */
    @NotNull
    private final Map<String, String> scopes;

    private OAuthFlowObject(final String authorizationUrl, final String tokenUrl, final String refreshUrl,
                            final Map<String, String> scopes, final Map<String, ?> extensions) {

        super(extensions);

        this.authorizationUrl = authorizationUrl;
        this.tokenUrl = tokenUrl;
        this.refreshUrl = refreshUrl;
        this.scopes = scopes;
    }

    public String getAuthorizationUrl() {
        return authorizationUrl;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public String getRefreshUrl() {
        return refreshUrl;
    }

    public Map<String, String> getScopes() {
        return scopes;
    }

    public static final class Builder extends ExtensibleObject.Builder {
        private String authorizationUrl;
        private String tokenUrl;
        private String refreshUrl;
        private Map<String, String> scopes;

        public static Builder builder() {
            return new Builder();
        }

        public Builder withAuthorizationUrl(final String authorizationUrl) {
            this.authorizationUrl = authorizationUrl;
            return this;
        }

        public Builder withTokenUrl(final String tokenUrl) {
            this.tokenUrl = tokenUrl;
            return this;
        }

        public Builder withRefreshUrl(final String refreshUrl) {
            this.refreshUrl = refreshUrl;
            return this;
        }

        public Builder withScopes(final Map<String, String> scopes) {
            this.scopes = scopes;
            return this;
        }

        public Builder withExtensions(final Map<String, ?> extensions) {
            this.extensions = extensions;
            return this;
        }

        public OAuthFlowObject build() {
            return new OAuthFlowObject(authorizationUrl, tokenUrl, refreshUrl, scopes, extensions);
        }
    }
}
