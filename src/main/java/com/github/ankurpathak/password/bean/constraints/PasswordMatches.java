package com.github.ankurpathak.password.bean.constraints;


import com.github.ankurpathak.password.bean.constraints.validator.PasswordMatchesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by ankur on 23-10-2016.
 */
@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchesValidator.class)
@Documented
@Repeatable(PasswordMatches.List.class)
public @interface PasswordMatches {
    String password() default "password";
    String confirmPassword() default "confirmPassword";

    boolean showErrorOnConfirmPassword() default true;

    String message() default "{com.github.ankurpathak.password.bean.constraints.PasswordMatches.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        PasswordMatches[] value();
    }
}