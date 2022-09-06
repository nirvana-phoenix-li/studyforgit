package com.li.everyday.march.m6_19;

import java.util.HashMap;

public class Solution3 {

    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < operations.length; i++) {
            Integer index = hashMap.get(operations[i][0]);
            nums[index] = operations[i][1];
            hashMap.put(operations[i][1],index);
        }
        return nums;

    }

//    public static void main(String[] args) {
//        new
//    }
}
