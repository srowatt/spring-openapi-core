package com.codineers.springopenapi.core.annotation;

import com.codineers.springopenapi.annotations.SoaContactObject;
import com.codineers.springopenapi.annotations.SoaInfoObject;
import com.codineers.springopenapi.annotations.SoaLicenseObject;
import org.junit.jupiter.api.Test;

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
