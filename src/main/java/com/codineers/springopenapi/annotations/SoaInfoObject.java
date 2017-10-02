package com.codineers.springopenapi.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
    ElementType.ANNOTATION_TYPE,
    ElementType.FIELD,
    ElementType.METHOD,
    ElementType.PACKAGE,
    ElementType.PARAMETER,
    ElementType.TYPE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SoaInfoObject {

    /**
     * The title of the application.
     */
    String title();

    /**
     * A short description of the application. CommonMark syntax MAY be used for rich text representation.
     */
    String description() default "";

    /**
     * A URL to the Terms of Service for the API. MUST be in the format of a URL.
     */
    String termsOfService() default "";

    /**
     * The contact information for the exposed API.
     */
    SoaContactObject contact() default @SoaContactObject();

    /**
     * The license information for the exposed API.
     */
    SoaLicenseObject license() default @SoaLicenseObject(name = "");

    /**
     * The version of the OpenAPI document (which is distinct from the OpenAPI Specification version or the API implementation version).
     */
    String version();
}
