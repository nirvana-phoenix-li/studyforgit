package com.li.everyday.july.hangzhou;

import java.util.ArrayList;

public class Solution3 {


    public static void main(String[] args) {
        Solution3 main = new Solution3();
//        [[0,1,0,0,0],[0,0,0,0,1],[0,0,1,0,0]]
        int[][] ints = {{0, 1, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 0}};
        int i = main.buildTransferStation(ints);
        System.out.println(i);
    }

    public int buildTransferStation2(int[][] area) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (area[i][j] == 1) {
                    arrayList.add(new int[]{i, j});
                }
            }
        }
        int cow = 0, col = 0;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            cow += arrayList.get(i)[0];
            col += arrayList.get(i)[1];
        }

        cow = Math.round((float) cow / size);
        col = Math.round((float) col / size);
        ArrayList<int[]> answer = new ArrayList<>();
        answer.add(new int[]{cow, col});
        answer.add(new int[]{cow - 1, col});
        answer.add(new int[]{cow + 1, col});
        answer.add(new int[]{cow, col - 1});
        answer.add(new int[]{cow, col + 1});
        int distance = Integer.MAX_VALUE;


        for (int j = 0; j < answer.size(); j++) {
            int temp = 0;
            for (int i = 0; i < size; i++) {
                int first = answer.get(j)[0];
                int second = answer.get(j)[1];
                int relate = Math.abs(arrayList.get(i)[0] - first) + Math.abs(arrayList.get(i)[1] - second);
                temp += relate;
            }
            if (temp < distance) distance = temp;
        }


        return distance;
    }

    public int buildTransferStation(int[][] area) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (area[i][j] == 1) {
                    arrayList.add(new int[]{i, j});
                }
            }
        }
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                int temp = 0;
                for (int k = 0; k < arrayList.size();k++) {

                    int relate = Math.abs(arrayList.get(k)[0] - i) + Math.abs(arrayList.get(k)[1] - j);
                    temp += relate;
                }
                if (temp < distance) distance = temp;
            }

        }
        return distance;
    }


}
