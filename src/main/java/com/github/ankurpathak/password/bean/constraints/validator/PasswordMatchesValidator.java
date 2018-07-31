package com.github.ankurpathak.password.bean.constraints.validator;



import com.github.ankurpathak.password.PasswordValidators;
import com.github.ankurpathak.password.bean.constraints.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ankur on 23-10-2016.
 */

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    private PasswordMatches config;
    @Override
    public void initialize(PasswordMatches config) {
        this.config = config;
    }

    @Override
    public boolean isValid(Object passwordDto, ConstraintValidatorContext context) {
        return PasswordValidators.matchPassword(passwordDto, config.password(), config.confirmPassword());
    }
}


