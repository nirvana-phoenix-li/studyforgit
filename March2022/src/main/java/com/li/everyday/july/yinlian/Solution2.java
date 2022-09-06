package com.li.everyday.july.yinlian;

public class Solution2 {


    public static void main(String[] args) {
        Solution2 main = new Solution2();
        int[] ints = {1, 0, 0, 1, 1, 1};
        int i = main.minSwaps(ints);
        System.out.println(i);

    }

    public int minSwaps(int[] chess) {
        int black = 0;
        int length = chess.length;
        for (int i = 0; i < length; i++) {
            if (chess[i] == 1) black++;
        }
        int[] slip = new int[length - black + 1];
        int temp = 0;
        for (int i = 0; i < black; i++) {
            if (chess[i] == 1) temp++;
        }
        slip[0] = temp;
        for (int i = 1; i < slip.length; i++) {
            int before = slip[i - 1];
            if (chess[i + black - 1] == 1) before++;
            if (chess[i - 1] == 1) before--;
            slip[i] = before;
        }
        int maxVal = -1;
        for (int i = 0; i < slip.length; i++) {
            if (slip[i] > maxVal) maxVal = slip[i];
        }
        return black - maxVal;
    }
}
