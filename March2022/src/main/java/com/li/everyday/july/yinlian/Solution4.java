package com.li.everyday.july.yinlian;

public class Solution4 {

    public static void main(String[] args) {
        Solution4 main = new Solution4();
        int i = main.idealArrays(5, 3);
        System.out.println(i);
        int[][] ints = {{0, 1, 5}, {1, 2, 10}, {2, 0, 5}, {2, 1, 1}};

    }

    public int idealArrays(int n, int maxValue) {
        int count = 0;
        for (int i = 1; i <= maxValue; i++) {
            int[] arr = new int[n];
            arr[0] = i;
            for (int k = 1; k < n; k++) {
                int help = 1;
                for (int j = help; j <= maxValue; j++) {
                    if (j % arr[k - 1] == 0) {
                        if (k == n - 1) {
                            count++;
                            k=1;
                            break;
                        }else {
                            j=1;
                            arr[k] = j;
                            k++;
                        }
                    } else {
                        k = 1;
                        help++;
                        j = help;
                    }
                }
            }

        }
        return count;
    }
}
