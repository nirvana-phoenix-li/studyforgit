package com.li.everyday.july.contest2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution4 {

    public static void main(String[] args) {
        Solution4 main = new Solution4();
//        distributions = [[0,1,5],[1,2,10],[2,0,5],[2,1,1]]
        int[][] ints = {{0, 1, 5}, {1, 2, 10}, {2, 0, 5}, {2, 1, 1}};
        int i = main.minTransfers(ints);
        System.out.println(i);

    }


    public int minTransfers(int[][] distributions) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < distributions.length; i++) {
            int one = distributions[i][0];
            int two = distributions[i][1];
            int three = distributions[i][2];
            if (!hashMap.containsKey(one)) {
                hashMap.put(one, 0);
            }
            if (!hashMap.containsKey(two)) {
                hashMap.put(two, 0);
            }
            hashMap.put(one, hashMap.get(one) - three);
            hashMap.put(two, hashMap.get(two) + three);
        }
        ArrayList<Integer> addList = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.get(integer) > 0) {
                addList.add(hashMap.get(integer));
            } else if (hashMap.get(integer) < 0) {
                subList.add(hashMap.get(integer));
            }
        }
        int count = 0;
        for (int i = 0; i < addList.size(); i++) {
            for (int j = 0; j < subList.size(); j++) {
                if (addList.get(i) != 0 && addList.get(i) == -subList.get(j)) {
                    count++;
                    addList.set(i, 0);
                    subList.set(j, 0);
                }
            }
        }
        Collections.sort(addList);
        Collections.sort(subList);
        int help=0;
        for (int i = addList.size()-1; i >=0 ; i--) {
            for (int j = 0; j <subList.size() ; j++) {
                help+=addList.get(i);
                help+=subList.get(j);

            }
        }


        return 0;

    }
}
