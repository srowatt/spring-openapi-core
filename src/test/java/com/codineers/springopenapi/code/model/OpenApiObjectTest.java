package com.codineers.springopenapi.code.model;

import com.codineers.springopenapi.annotations.SoaContactObject;
import com.codineers.springopenapi.annotations.SoaInfoObject;
import com.codineers.springopenapi.annotations.SoaLicenseObject;
import com.codineers.springopenapi.core.model.ComponentsObject;
import com.codineers.springopenapi.core.model.ContactObject;
import com.codineers.springopenapi.core.model.ExternalDocumentationObject;
import com.codineers.springopenapi.core.model.InfoObject;
import com.codineers.springopenapi.core.model.LicenseObject;
import com.codineers.springopenapi.core.model.OpenApiObject;
import com.codineers.springopenapi.core.model.PathsObject;
import com.codineers.springopenapi.core.model.SecurityRequirementObject;
import com.codineers.springopenapi.core.model.ServerObject;
import com.codineers.springopenapi.core.model.TagObject;
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
