package com.github.ankurpathak.password;

import com.github.ankurpathak.password.util.Strings;
import org.passay.*;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Objects;

public class PasswordValidators {

    public static boolean containDigit(String password, int count, boolean ignoreBlank) {
        return contain(password, count, ignoreBlank, EnglishCharacterData.Digit);
    }

    public static boolean containUppercase(String password, int count, boolean ignoreBlank) {
        return contain(password, count, ignoreBlank, EnglishCharacterData.UpperCase);
    }

    public static boolean containLowercase(String password, int count, boolean ignoreBlank) {
        return contain(password, count, ignoreBlank, EnglishCharacterData.LowerCase);
    }

    public static boolean containSpecial(String password, int count, boolean ignoreBlank) {
        return contain(password, count, ignoreBlank, EnglishCharacterData.Special);
    }

    public static boolean containDigit(String password) {
        return containDigit(password, 1, true);
    }

    public static boolean containLowercase(String password) {
        return containLowercase(password, 1, true);
    }

    public static boolean containUppercase(String password) {
        return containUppercase(password, 1, true);
    }

    public static boolean containSpecial(String password) {
        return containSpecial(password, 1, true);
    }


    private static boolean contain(String password, int count, boolean ignoreBlank, EnglishCharacterData rule) {
        if (Strings.isBlank(password))
            return ignoreBlank;
        else
            return new PasswordValidator(Collections.singletonList(new CharacterRule(rule))).validate(new PasswordData(password)).isValid();
    }

    public static boolean notContainWhiteSpace(String password){
        return new PasswordValidator(Collections.singletonList(new WhitespaceRule())).validate(new PasswordData(password)).isValid();
    }


    public static boolean matchPassword(Object passwordDto, String password, String confirmPassword)  {
        try{
            Field passwordField = passwordDto.getClass().getDeclaredField(password);
            Field confirmPasswordField = passwordDto.getClass().getDeclaredField(confirmPassword);
            passwordField.setAccessible(true);
            confirmPasswordField.setAccessible(true);
            Object passwordValue = passwordField.get(passwordDto);
            Object confirmPasswordValue = confirmPasswordField.get(passwordDto);
            passwordField.setAccessible(false);
            confirmPasswordField.setAccessible(false);
            return Objects.equals(passwordValue, confirmPasswordValue);
        }catch (NoSuchFieldException | IllegalAccessException ex){
            return false;
        }

    }

}
