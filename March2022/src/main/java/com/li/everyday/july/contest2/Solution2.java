package com.li.everyday.july.contest2;

import java.util.*;

public class Solution2 {


    public static void main(String[] args) {
        Solution2 main = new Solution2();
        int[] ints = {1, 0, 0, 1, 1, 1};

    }

    private static int countAllNum(int input) {
        int temp = 0;
        while (input > 0) {
            temp += input % 10;
            input /= 10;
        }
        return temp;
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int allNum = countAllNum(nums[i]);
            if (!hashMap.containsKey(allNum)) {

                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(nums[i]);
                hashMap.put(allNum, arrayList);
            } else {
                hashMap.get(allNum).add(nums[i]);
            }
        }
        int maxValue = -1;
        for (Integer integer : hashMap.keySet()) {
            List<Integer> list = hashMap.get(integer);
            if (list.size() > 1) {
                Collections.sort(list, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
                int i = list.get(0) + list.get(1);
                if (i > maxValue) maxValue = i;

            }
        }
        return maxValue;
    }
}
