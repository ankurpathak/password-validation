package com.github.ankurpathak.password.bean.constraints.validator;

import com.github.ankurpathak.password.PasswordValidators;
import com.github.ankurpathak.password.bean.constraints.NotContainWhitespace;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ankur on 04-02-2017.
 */
public class NotContainWhitespaceValidator implements ConstraintValidator<NotContainWhitespace, String> {
    private NotContainWhitespace config;
    @Override
    public void initialize(NotContainWhitespace config) {
        this.config = config;
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return PasswordValidators.notContainWhiteSpace(password, config.ignoreBlank());
    }

}
