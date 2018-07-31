package com.github.ankurpathak.password.bean.constraints.validator;

import com.github.ankurpathak.password.PasswordValidators;
import com.github.ankurpathak.password.bean.constraints.ContainDigit;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by ankur on 04-02-2017.
 */
public class ContainDigitValidator implements ConstraintValidator<ContainDigit, String> {
    private ContainDigit config;
    @Override
    public void initialize(ContainDigit config) {
        this.config = config;
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return PasswordValidators.containDigit(password, config.count(), config.ignoreBlank());
    }

}
