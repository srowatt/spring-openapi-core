package com.codineers.springopenapi.core.model;

/**
 * Allows configuration of the supported OAuth Flows.
 */
public class OAuthFlowsObject {
    /**
     * Configuration for the OAuth Implicit flow
     */
    private OAuthFlowsObject implicit;

    /**
     * Configuration for the OAuth Resource Owner Password flow
     */
    private OAuthFlowsObject password;

    /**
     * Configuration for the OAuth Client Credentials flow. Previously called application in OpenAPI 2.0.
     */
    private OAuthFlowsObject clientCredentials;

    /**
     * Configuration for the OAuth Authorization Code flow. Previously called accessCode in OpenAPI 2.0.
     */
    private OAuthFlowsObject authorizationCode;
}
