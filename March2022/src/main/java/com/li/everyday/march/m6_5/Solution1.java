package com.li.everyday.march.m6_5;

public class Solution1 {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        while (nums.length!=1){
            boolean isMin=true;
            int[] temp = new int[nums.length / 2];
            for (int i = 0; i < nums.length/2; i++) {
                if (isMin){
                    temp[i]=Math.min(nums[i*2],nums[i*2+1]);
                }else {
                    temp[i]=Math.max(nums[i*2],nums[i*2+1]);
                }
                isMin=!isMin;
            }
            nums=temp;
        }
        return nums[0];
    }

   
}
