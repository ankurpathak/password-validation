package com.github.ankurpathak.password.util;

import java.util.Objects;

public class Strings {

    public static final String BLANK = "";

    public static boolean isBlank(String string){
        return string == null || Objects.equals(string.trim(), BLANK);
    }


    public static Character firstChar(String string){
        if(!isBlank(string)){
            return string.charAt(0);
        }else {
            return null;
        }
    }

    public static Character lastChar(String string){
        if(!isBlank(string)){
            return string.charAt(string.length() - 1);
        }else {
            return null;
        }
    }


}
