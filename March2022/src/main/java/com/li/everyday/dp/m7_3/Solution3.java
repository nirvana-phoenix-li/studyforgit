package com.li.everyday.dp.m7_3;

import java.util.ArrayList;

public class Solution3 {

    static final int MOD = (int) 1e9 + 7;

    public static void main(String[] args) {
        Solution3 main = new Solution3();
        int[] ints = {5, -1, 3, 4, 5, 6, -1, -1, 4, 3};
        int i = main.closestMeetingNode(ints, 0, 0);
        System.out.println(i);

    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (edges[node1] == edges[node2]) return 0;
        ArrayList<Integer> temp1 = new ArrayList<>();
        if (edges[node1] == -1) temp1.add(node1);
        while (edges[node1] != -1) {
            if (temp1.contains(edges[node1])) {
                break;
            }
            temp1.add(edges[node1]);
            node1 = edges[node1];
        }

        ArrayList<Integer> temp2 = new ArrayList<>();
        if (edges[node2] == -1) temp2.add(node2);
        while (edges[node2] != -1) {
            if (temp2.contains(edges[node2])) {
                break;
            }
            temp2.add(edges[node2]);
            node2 = edges[node2];
        }
        int res = Integer.MAX_VALUE;
        boolean isEnter = false;
        for (int i = 0; i < temp1.size(); i++) {
            Integer integer1 = temp1.get(i);
            for (int j = 0; j < temp2.size(); j++) {
                Integer integer2 = temp2.get(j);
                if (integer1.equals(integer2)) {
                    isEnter = true;
                    int help = Math.max(i, j);
                    if (help < res) res = help;
                }

            }
        }
        if (isEnter) return edges[res];
        else return -1;
    }

}
