package com.li.easy;

public class CountAsterisks2315 {

    public int countAsterisks(String s) {
        int count = 0;
        String[] split = s.split("\\|");

        for (int i = 0; i < (split.length + 1) / 2; i++) {
            String s1 = split[i*2];
            count += containsNum(s1);

        }
        return count;
    }

    private int containsNum(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '*') count++;

        }
        return count;
    }

    public static void main(String[] args) {
        CountAsterisks2315 main = new CountAsterisks2315();
        String s = "yo|uar|e**|b|e***au|tifu|l";
        int i = main.countAsterisks(s);
        System.out.println(i);
    }

}
