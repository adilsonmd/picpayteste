package com.athomus.picpayteste.Utils;

public class StringUtils {
    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        else return str.isEmpty() || str.isBlank();
    }
}
