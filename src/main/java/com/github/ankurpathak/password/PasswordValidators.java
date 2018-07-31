package com.github.ankurpathak.password;

import com.github.ankurpathak.password.util.Strings;
import org.passay.*;

import java.util.Collections;

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

}
