package com.github.ankurpathak.password.bean.constraints;

/**
 * Created by ankur on 04-02-2017.
 */

import com.github.ankurpathak.password.bean.constraints.validator.ContainLowercaseValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContainLowercaseValidator.class)
@Documented
@Repeatable(ContainLowercase.List.class)
public @interface ContainLowercase {

    int count() default 1;

    boolean ignoreBlank() default true;

    String message() default "{com.github.ankurpathak.password.bean.constraints.ContainUppercase.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        ContainLowercase[] value();
    }
}
