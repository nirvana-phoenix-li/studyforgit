package com.li.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LongYiTest {
    public static void main(String[] args) {
        int[] arr = createRandow18Arr(0, 300);
        Arrays.sort(arr);
        Object[] objects = getTwoDimenArr(arr);
        System.out.println(Arrays.toString(objects));
    }

    private static Object[] getTwoDimenArr(int[] arr) {
        ArrayList<List<Integer>> outList = new ArrayList<>();
        int current = 1;
        boolean isChanged=true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < current * 10 && arr[i] >= (current - 1) * 10) {
                if (isChanged) {
                    ArrayList<Integer> innerList = new ArrayList<>();
                    innerList.add(arr[i]);
                    outList.add(innerList);
                    isChanged=false;
                } else {
                    outList.get(outList.size()-1).add(arr[i]);
                }
            } else {
                current++;
                i--;
                isChanged=true;
            }

        }
        return outList.toArray();
    }


    private static int[] createRandow18Arr(int randomstart, int step) {
        int[] ints = new int[18];
        Random random = new Random();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = random.nextInt(step) + randomstart;
        }
        return ints;
    }


}


// 使用程序生成长度18的整数数组，形如
// [
//   16, 27, 61, 95, 8, 21, 86,
//   66, 81, 76, 81, 0, 36, 58,
//   22, 90, 96, 67
// ]

// 将生成的数组处理成一个新数组，要求新数组格式如下，形如
// [
//   [ 0, 8 ],
//   [ 16 ],
//   [ 21, 22, 27 ],
//   [ 36 ],
//   [ 58 ],
//   [ 61, 66, 67 ],
//   [ 76 ],
//   [ 81, 86 ],
//   [ 90, 95, 96 ]
// ]

//注：先说下思路，可以直接在下方写java代码，可以使用任何内置方法，点击左上角运行按钮随时调试
