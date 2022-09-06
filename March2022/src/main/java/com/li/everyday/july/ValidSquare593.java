package com.li.everyday.july;

import java.util.Arrays;

public class ValidSquare593 {
    public static void main(String[] args) {
        ValidSquare593 main = new ValidSquare593();
        int[] ints1 = {1, 1};
        int[] ints2 = {5, 3};
        int[] ints3 = {3, 5};
        int[] ints4 = {7, 7};

        boolean b = main.validSquare(ints1, ints2, ints3, ints4);
        System.out.println(b);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if ((Arrays.equals(p1, p2) && Arrays.equals(p1, p3))
                || (Arrays.equals(p1, p2) && Arrays.equals(p1, p4))
                || (Arrays.equals(p1, p3) && Arrays.equals(p1, p4))
                || (Arrays.equals(p3, p2) && Arrays.equals(p2, p4))) {
            return false;
        }


        int i1 = isParallel(p1, p2, p3, p4) + isParallel(p1, p3, p2, p4);
        int i2 = isParallel(p1, p4, p2, p3) + isParallel(p1, p2, p3, p4);
        int i3 = isParallel(p1, p4, p2, p3) + isParallel(p1, p3, p2, p4);
        if (i1 < 0 || i2 < 0 || i3 < 0) return false;
        return i1 == 2 || i2 == 2 || i3 == 2;
    }

    private int isParallel(int[] p1, int[] p2, int[] h1, int[] h2) {
        int longitude = Math.abs(p1[1] - p2[1]);
        int dimension = Math.abs(p1[0] - p2[0]);

        int longitude2 = Math.abs(h1[1] - h2[1]);
        int dimension2 = Math.abs(h1[0] - h2[0]);
        if (dimension == 0 && dimension2 == 0) {
            int abs = Math.abs(p1[0] - h1[0]);
            if (abs == longitude) {
                return 1;
            } else {
                return -100;
            }
        }
        longitude *= dimension2;
        longitude2 *= dimension;
        return longitude == longitude2 ? 1 : 0;

    }
}
