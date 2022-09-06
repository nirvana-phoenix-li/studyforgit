package com.li.everyday.july.contest2;

import java.util.HashSet;

public class Solution1 {

    public static void main(String[] args) {


        Solution1 main = new Solution1();



    }


    public int[] numberOfPairs(int[] nums) {
        int[] resArr = new int[2];
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <nums.length; i++) {
            if  (!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                set.remove(nums[i]);
                count++;
            }
        }
        resArr[0]=count;
        resArr[1]=set.size();
        return resArr;
    }


}
