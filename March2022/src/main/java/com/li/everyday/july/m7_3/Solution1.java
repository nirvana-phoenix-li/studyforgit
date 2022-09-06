package com.li.everyday.july.m7_3;

import java.util.ArrayList;

public class Solution1 {

    public static void main(String[] args) {
        Solution1 main = new Solution1();
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        String s = main.decodeMessage(key, message);
        System.out.println(s);


    }

    public String decodeMessage(String key, String message) {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            if (key.charAt(i)==' ')continue;
            if (!list.contains(key.charAt(i))) {
                list.add(key.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i)==' '){
                sb.append(' ');
            }else {
                int index = list.indexOf(message.charAt(i));
                char c = (char) (97 + index);
                sb.append(c);
            }

        }
        return sb.toString();
    }


}
