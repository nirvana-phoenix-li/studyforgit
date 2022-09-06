package com.li.everyday.july.contest2;

import java.math.BigInteger;
import java.util.*;

public class Solution3 {


    public static void main(String[] args) {
        Solution3 main = new Solution3();
        String[] nums = {"102","473","251","814"};
//        int[][] queries = {{2, 1}, {2, 2}};
        int[][] queries = {{1, 1}, {2, 3}, {4, 2}, {1, 2}};
        int[] ints = main.smallestTrimmedNumbers(nums, queries);
        System.out.println(Arrays.toString(ints));
    }

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int length = nums.length;
        int[] resIndex = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int pow = queries[i][1];
            BigInteger[] tempArr = new BigInteger[length];
            for (int j = 0; j < length; j++) {
//                int pow1 = (int) Math.pow(10, pow);
//                tempArr[j] = ((Long.parseLong(nums[j])) % (pow1));
                String substring = nums[j].substring(nums[j].length() - pow);
                tempArr[j] =new BigInteger(substring);
            }

            HashMap<BigInteger, List<Integer>> hashMap = new HashMap<>();
            for (int j = 0; j < tempArr.length; j++) {
                if (!hashMap.containsKey(tempArr[j])) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(j);
                    hashMap.put(tempArr[j], arrayList);
                } else {
                    hashMap.get(tempArr[j]).add(j);
                }
            }


            Set set = hashMap.keySet();
            Object[] arr = set.toArray();
            Arrays.sort(arr);
            int times = queries[i][0];
            for (Object key : arr) {
                long key1 = (long) key;
                if (hashMap.get(key1).size() >= times) {
                    Integer integer = hashMap.get(key1).get(times - 1);
                    resIndex[i] = integer;
                    break;
                } else {
                    times -= hashMap.get(key1).size();
                }
            }

        }
        return resIndex;
    }


}
