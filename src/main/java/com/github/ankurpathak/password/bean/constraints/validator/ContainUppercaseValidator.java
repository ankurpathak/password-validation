package com.github.ankurpathak.password.bean.constraints.validator;

import com.github.ankurpathak.password.PasswordValidators;
import com.github.ankurpathak.password.bean.constraints.ContainUppercase;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by ankur on 04-02-2017.
 */
public class ContainUppercaseValidator implements ConstraintValidator<ContainUppercase, String> {
    private ContainUppercase config;
    @Override
    public void initialize(ContainUppercase containUppercase) {
        this.config = config;
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return PasswordValidators.containUppercase(password, config.count(), config.ignoreBlank());
    }

}
