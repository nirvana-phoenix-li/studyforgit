package com.li.everyday.july.m7_3;

import java.util.Arrays;

public class Solution2 {
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count =1;
        int help = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - help <= k) {
                continue;
            } else {
                count++;
                help = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution2 main = new Solution2();
        int[] ints = {2,2,4,5};
        int array = main.partitionArray(ints, 0);
        System.out.println(array);
    }
}
