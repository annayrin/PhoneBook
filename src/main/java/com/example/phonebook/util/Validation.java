package com.example.phonebook.util;

import com.example.phonebook.model.util.Lable;

import java.awt.*;

public class Validation {
    public static final int NAME_LENGTH = 10;

    public static final String regexEmail = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static final String regexPhone = "^[+][3][7][4][-\\s/0-9]{8,16}$|[0][-\\s\\./0-9]{8,12}$";

    public static final Lable[] lable = Lable.values();

}
