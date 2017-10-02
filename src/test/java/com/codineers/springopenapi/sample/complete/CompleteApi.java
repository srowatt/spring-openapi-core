package com.codineers.springopenapi.sample.complete;

import com.codineers.springopenapi.annotations.SoaContactObject;
import com.codineers.springopenapi.annotations.SoaInfoObject;
import com.codineers.springopenapi.annotations.SoaLicenseObject;

@SoaInfoObject(
    version = "info version",
    title = "info title",
    description = "info description",
    termsOfService = "info terms of service",
    contact = @SoaContactObject(
        name = "contact name",
        url = "contact url",
        email = "contact email"
    ),
    license = @SoaLicenseObject(
        name = "license name",
        url = "license url"
    )
)
public class CompleteApi {
}
