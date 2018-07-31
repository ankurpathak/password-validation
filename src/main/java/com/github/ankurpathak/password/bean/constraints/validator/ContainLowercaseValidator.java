package com.github.ankurpathak.password.bean.constraints.validator;

import com.github.ankurpathak.password.PasswordValidators;
import com.github.ankurpathak.password.bean.constraints.ContainLowercase;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by ankur on 04-02-2017.
 */
public class ContainLowercaseValidator implements ConstraintValidator<ContainLowercase, String> {
    private ContainLowercase config;
    @Override
    public void initialize(ContainLowercase config) {
        this.config = config;
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return PasswordValidators.containUppercase(password, config.count(), config.ignoreBlank());
    }

}
