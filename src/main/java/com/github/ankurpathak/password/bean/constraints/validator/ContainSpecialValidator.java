package com.github.ankurpathak.password.bean.constraints.validator;

import com.github.ankurpathak.password.PasswordValidators;
import com.github.ankurpathak.password.bean.constraints.ContainSpecial;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

/**
 * Created by ankur on 04-02-2017.
 */
public class ContainSpecialValidator implements ConstraintValidator<ContainSpecial, String> {
    private ContainSpecial config;
    @Override
    public void initialize(ContainSpecial config) {
        this.config = config;
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        return PasswordValidators.containSpecial(password, config.count(), config.ignoreBlank());
    }

}
