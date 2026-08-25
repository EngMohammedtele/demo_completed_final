package com.cl.demo.utils;

public class HelperUtils {

    public static <T> T compare(T original, T update) {
        return update == null ? original : update;
    }
}
