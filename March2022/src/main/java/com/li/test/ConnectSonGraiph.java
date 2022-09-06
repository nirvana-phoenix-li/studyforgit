package com.li.test;


import java.util.ArrayList;
import java.util.List;

/**
 * 1. 给定一个图G，有N个节点，其邻接矩阵为arr[N][N]，其中arr[i][j]如果为1，那么代表第i个节点和第j个节点之间是有直接连线的，反之arr[i][j]为0。请写出一个算法用于计算该图G中的联通子图的数量。比如下图联通子图的数量为3.（30分）
 * [图片]
 * 提示：输入为arr[N][N]，该图为无向图，所以arr[i][j]=arr[j][i]
 */
public class ConnectSonGraiph {
    public static void main(String[] args) {
        int[][] input = {{1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 0}, {0, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 1}};
        int i = countNum(input);
        System.out.println(i);

    }

    private static int countNum(int[][] input) {
        if (input == null || input.length == 0) return 0;
        int length = input.length;
        boolean[] flags = new boolean[length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (flags[i]) {
                continue;
            } else {
                //需要递归
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = 0; j < length; j++) {
                    if (j == i) continue;
                    if (!flags[j] && input[i][j] == 1) {
                        arrayList.add(j);
                        flags[j] = true;
                    }
                }
                if (arrayList.size() != 0) {
                    change(arrayList, length, flags, input);
                }
                count++;


            }
        }
        return count;

    }

    private static void change(List<Integer> arrayList, int length, boolean[] flags, int[][] input) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer integer : arrayList) {
            for (int j = 0; j < length; j++) {
                if (!flags[j] && input[integer][j] == 1) {
                    list.add(j);
                    flags[j] = true;
                }
            }
        }
        if (list.size() != 0) {
            change(list, length, flags, input);
        }
    }


}
