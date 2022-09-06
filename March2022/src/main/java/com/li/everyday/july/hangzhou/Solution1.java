package com.li.everyday.july.hangzhou;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution1 {

    public static void main(String[] args) {


        Solution1 main = new Solution1();
//        signals = [[2,8],[8,14]]

//        [[9,10],[4,9],[4,17]]
        int[][] signals = {{9,10}, {4,9}, {4,17}};
        boolean b = main.canReceiveAllSignals(signals);
        System.out.println(b);


    }


    public boolean canReceiveAllSignals(int[][] intervals) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] ints = intervals[i];
            for (int j = 0; j <arrayList.size() ; j++) {
                if ((ints[0]>arrayList.get(j)[0]&&ints[0]<arrayList.get(j)[1])||(ints[1]>arrayList.get(j)[0]&&ints[1]<arrayList.get(j)[1])||(ints[0]<=arrayList.get(j)[0]&&ints[1]>=arrayList.get(j)[1])){
                    return false;
                }
            }
            arrayList.add(ints);

        }
        return true;

    }



}
