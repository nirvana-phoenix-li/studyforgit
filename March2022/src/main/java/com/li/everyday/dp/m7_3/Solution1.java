package com.li.everyday.dp.m7_3;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution1 {

//    public static void main(String[] args) {
//        Solution1 main = new Solution1();
//        String key = "the quick brown fox jumps over the lazy dog";
//        String message = "vkbs bs t suepuv";
//        String s = main.decodeMessage(key, message);
//        System.out.println(s);
//
//
//    }

    public int minimumOperations(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        if (hashSet.contains(0)){
            return hashSet.size()-1;
        }else {
            return hashSet.size();
        }
    }

}
