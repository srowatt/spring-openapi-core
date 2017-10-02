package com.codineers.springopenapi.core.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;

public class OpenApiObjectTest {

    @Test
    public void build() {
        final ContactObject contactObject = ContactObject.Builder.builder()
                .withName("name")
                .withUrl("url")
                .withEmail("email")
                .build();

        final LicenseObject licenseObject = LicenseObject.Builder.builder()
                .withName("name")
                .withUrl("url")
                .build();

        final InfoObject infoObject = InfoObject.Builder.builder()
                .withContact(contactObject)
                .withDescription("description")
                .withLicense(licenseObject)
                .withTermsOfService("terms of service")
                .withTitle("title")
                .withVersion("version")
                .build();

        final ComponentsObject componentsObject = ComponentsObject.Builder.builder()
                .build();

        final ExternalDocumentationObject externalDocumentationObject = ExternalDocumentationObject.Builder.builder()
                .withDescription("description")
                .withUrl("url")
                .build();

        final PathsObject pathsObject = PathsObject.Builder.builder()
                .withPath(null) //TODO
                .build();

        final SecurityRequirementObject securityRequirementObject = SecurityRequirementObject.Builder.builder()
                .build();

        final ServerObject serverObject = ServerObject.Builder.builder()
                .withDescription("description")
                .withUrl("url")
                .withVariables(null) // TODO
                .build();

        final TagObject tagObject = TagObject.Builder.builder()
                .build();


        OpenApiObject openApiObject = OpenApiObject.Builder.builder()
                .withInfo(infoObject)
                .withComponents(componentsObject)
                .withExternalDocs(externalDocumentationObject)
                .withOpenapi("openapi")
                .withPaths(pathsObject)
                .withSecurity(Collections.singletonList(securityRequirementObject))
                .withServers(Collections.singletonList(serverObject))
                .withTags(Collections.singletonList(tagObject))
                .build();
    }
}
