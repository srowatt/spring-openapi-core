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
    private String authorizationUrl;

    /**
     * The token URL to be used for this flow. This MUST be in the form of a URL.
     *
     * Applies to: oauth2 ("password", "clientCredentials", "authorizationCode")
     */
    @NotBlank
    private String tokenUrl;

    /**
     * The URL to be used for obtaining refresh tokens. This MUST be in the form of a URL.
     *
     * Applies to: oauth2
     */
    private String refreshUrl;

    /**
     * The available scopes for the OAuth2 security scheme. A map between the scope name and a short description for it.
     *
     * Applies to: oauth2
     */
    @NotNull
    private Map<String, String> scopes;

    public OAuthFlowObject(Map<String, ?> extensions, @NotBlank String authorizationUrl, @NotBlank String tokenUrl, String refreshUrl, @NotNull Map<String, String> scopes) {
        super(extensions);
        this.authorizationUrl = authorizationUrl;
        this.tokenUrl = tokenUrl;
        this.refreshUrl = refreshUrl;
        this.scopes = scopes;
    }
}
