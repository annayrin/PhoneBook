package com.example.phonebook.util;

import com.example.phonebook.model.util.Lable;

import java.awt.*;
import java.util.regex.Pattern;

public class Validator {
    public static  boolean checkLength(final String value, final int length){
        return value.length()==length;
    }

    public static boolean checkLabel(final Lable value, Lable[] lable){

        for (int i = 0; i < lable.length; i++){
            if (lable[i] == value) return true;
        }
        return false;
    }
    public static boolean doValidation(String regExp, String str) {
        return Pattern.compile(regExp).matcher(str).matches();
    }


}
