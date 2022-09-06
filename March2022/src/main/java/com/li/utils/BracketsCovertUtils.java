package com.li.utils;

public class BracketsCovertUtils {

    public static void main(String[] args) {
        String input="[[1,1],[2,3],[4,2],[1,2]]";

        String covert = covert(input);
        System.out.println(covert);


    }

    private static String covert(String input) {
        String replace = input.replace("[", "{").replace("]", "}");
        return replace;
    }
}
