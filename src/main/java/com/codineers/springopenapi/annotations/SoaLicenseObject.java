package com.codineers.springopenapi.annotations;

import javax.validation.constraints.NotBlank;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PACKAGE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface SoaLicenseObject {
    /**
     * The license name used for the API.
     */
    String name();

    /**
     * A URL to the license used for the API. MUST be in the format of a URL.
     */
    String url() default "";
}
