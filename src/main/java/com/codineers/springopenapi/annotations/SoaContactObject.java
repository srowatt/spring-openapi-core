package com.codineers.springopenapi.annotations;

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
public @interface SoaContactObject {
    /**
     * The identifying name of the contact person/organization.
     */
    String name() default "";

    /**
     * The URL pointing to the contact information. MUST be in the format of a URL.
     */
   String url() default "";

    /**
     * The email address of the contact person/organization. MUST be in the format of an email address.
     */
    String email() default "";
}
