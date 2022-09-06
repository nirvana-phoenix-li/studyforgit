package com.li.everyday.july.yinlian;

import java.util.Arrays;

public class Solution1 {

    public static void main(String[] args) {


        Solution1 main = new Solution1();
        int[] ints = {5, 4, 4};
        int i = main.fillCups(ints);
        System.out.println(i);


    }


    public int fillCups(int[] amount) {
        int result = 0;
        Arrays.sort(amount);
        int i = amount[0] + amount[1];
        int j = amount[2];
        if (i<j){
            result += Math.min(i, j);
            result += Math.abs(i - j);
        }else if (i==j){
            return j;
        }else {
            int i1 = (i + j) / 2+(i + j) % 2;
            return i1;
        }
        return result;

    }


}
