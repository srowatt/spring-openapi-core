package com.codineers.springopenapi.code.annotation;

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

public class SoaInfoObjectTest {

    @Test
    public void build() {

    }

    @SoaInfoObject(
            title = "title",
            version = "version",
            description = "description",
            termsOfService = "terms of service",
            contact = @SoaContactObject(
                    name = "name",
                    url = "url",
                    email = "email"),
            license = @SoaLicenseObject(
                    name = "name",
                    url = "url"
            )
    )
    public void testSoaObjectInfo() {

    }


}
