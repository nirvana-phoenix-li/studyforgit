package com.li.everyday.may;

import java.util.Arrays;

/**
 * 2281. 巫师的总力量和
 * 作为国王的统治者，你有一支巫师军队听你指挥。
 * <p>
 * 给你一个下标从 0 开始的整数数组 strength ，其中 strength[i] 表示第 i 位巫师的力量值。对于连续的一组巫师（也就是这些巫师的力量值是 strength 的 子数组），总力量 定义为以下两个值的 乘积 ：
 * <p>
 * 巫师中 最弱 的能力值。
 * 组中所有巫师的个人力量值 之和 。
 * 请你返回 所有 巫师组的 总 力量之和。由于答案可能很大，请将答案对 109 + 7 取余 后返回。
 * <p>
 * 子数组 是一个数组里 非空 连续子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strength = [1,3,1,2]
 * 输出：44
 * 解释：以下是所有连续巫师组：
 * - [1,3,1,2] 中 [1] ，总力量值为 min([1]) * sum([1]) = 1 * 1 = 1
 * - [1,3,1,2] 中 [3] ，总力量值为 min([3]) * sum([3]) = 3 * 3 = 9
 * - [1,3,1,2] 中 [1] ，总力量值为 min([1]) * sum([1]) = 1 * 1 = 1
 * - [1,3,1,2] 中 [2] ，总力量值为 min([2]) * sum([2]) = 2 * 2 = 4
 * - [1,3,1,2] 中 [1,3] ，总力量值为 min([1,3]) * sum([1,3]) = 1 * 4 = 4
 * - [1,3,1,2] 中 [3,1] ，总力量值为 min([3,1]) * sum([3,1]) = 1 * 4 = 4
 * - [1,3,1,2] 中 [1,2] ，总力量值为 min([1,2]) * sum([1,2]) = 1 * 3 = 3
 * - [1,3,1,2] 中 [1,3,1] ，总力量值为 min([1,3,1]) * sum([1,3,1]) = 1 * 5 = 5
 * - [1,3,1,2] 中 [3,1,2] ，总力量值为 min([3,1,2]) * sum([3,1,2]) = 1 * 6 = 6
 * - [1,3,1,2] 中 [1,3,1,2] ，总力量值为 min([1,3,1,2]) * sum([1,3,1,2]) = 1 * 7 = 7
 * 所有力量值之和为 1 + 9 + 1 + 4 + 4 + 4 + 3 + 5 + 6 + 7 = 44 。
 * 示例 2：
 * <p>
 * 输入：strength = [5,4,6]
 * 输出：213
 * 解释：以下是所有连续巫师组：
 * - [5,4,6] 中 [5] ，总力量值为 min([5]) * sum([5]) = 5 * 5 = 25
 * - [5,4,6] 中 [4] ，总力量值为 min([4]) * sum([4]) = 4 * 4 = 16
 * - [5,4,6] 中 [6] ，总力量值为 min([6]) * sum([6]) = 6 * 6 = 36
 * - [5,4,6] 中 [5,4] ，总力量值为 min([5,4]) * sum([5,4]) = 4 * 9 = 36
 * - [5,4,6] 中 [4,6] ，总力量值为 min([4,6]) * sum([4,6]) = 4 * 10 = 40
 * - [5,4,6] 中 [5,4,6] ，总力量值为 min([5,4,6]) * sum([5,4,6]) = 4 * 15 = 60
 * 所有力量值之和为 25 + 16 + 36 + 36 + 40 + 60 = 213 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strength.length <= 105
 * 1 <= strength[i] <= 109
 * 通过次数2,024提交次数9,407
 */
public class TotalStrength2281 {
    public static void main(String[] args) {
        TotalStrength2281 main = new TotalStrength2281();
//        [5,6,12]
        int[] strength = new int[]{1,3,1,2};
        int i = main.totalStrength(strength);
        System.out.println(i);
    }

    public int totalStrength(int[] strength) {
        int result = 0;
        int length = strength.length;
        int curLen = 1;
        int lastMin = 0;
        int lastTol = 0;
        int lastIndex = -1;
        int minArrVal = Integer.MAX_VALUE;
        int totalVal = 0;

        while (curLen <= length) {
            for (int i = 0; i <= length - curLen; i++) {
                if (i == 0) {
                    int[] ints = Arrays.copyOfRange(strength, i, i + curLen);
                    int[] arrVal = minArrVal(ints);
                    minArrVal = arrVal[1];
                    totalVal = arrVal[2];
                    lastMin = minArrVal;
                    lastTol = totalVal;
                    lastIndex = arrVal[0];

                } else {
                    int tail = strength[i + curLen - 1];
                    int head = strength[i - 1];

                    if (tail < lastMin) {
                        lastMin = tail;
                        lastIndex = i + curLen;
                    }
                    if (lastIndex == i - 1) {
                        int[] arrVal = minArrVal(Arrays.copyOfRange(strength, i, i + curLen));
                        lastIndex = arrVal[0] + i;
                        minArrVal = arrVal[1];
                        totalVal = arrVal[2];
                        lastMin = minArrVal;
                    } else if (lastIndex > i - 1) {
                        if (tail > lastMin) {
                            minArrVal = lastMin;
                            totalVal = lastTol + tail - head;
                        } else if (tail <= lastMin) {
                            lastIndex = i + curLen - 1;
                            minArrVal = tail;
                            totalVal = lastTol + tail - head;
                            lastMin = minArrVal;
                        }
                    }
                    lastTol = totalVal;
                }
                result += minArrVal * totalVal;
                result %= 1000000000 + 7;

            }
            curLen++;
        }
        return result;
    }

    //(最小值索引，最小值，总数)
    private int[] minArrVal(int[] arr) {
        int min = Integer.MAX_VALUE;
        int total = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            if (arr[i] <= min) {
                min = arr[i];
                index = i;
            }
        }

        return new int[]{index, min, total};
    }


//    public int totalStrength(int[] strength) {
//        int result = 0;
//        int length = strength.length;
//        int curLen = 1;
//        int lastMin = 0;
//        int lastTol = 0;
//        int lastIndex = -1;
//        int minArrVal = Integer.MAX_VALUE;
//        int totalVal = 0;
//
//        int[] firstArr = null;
//
//        while (curLen <= length) {
//            for (int i = 0; i <= length - curLen; i++) {
//                if (i == 0) {
//                    if (firstArr == null) {
//                        int[] ints = Arrays.copyOfRange(strength, i, i + curLen);
//                        int[] arrVal = minArrVal(ints);
//                        minArrVal = arrVal[1];
//                        totalVal = arrVal[2];
//                        lastMin = minArrVal;
//                        lastTol = totalVal;
//                        lastIndex = arrVal[0];
//                        firstArr = new int[]{lastIndex, lastMin, lastTol};
//                    } else {
//                        if (strength[curLen-1]<=firstArr[1]){
//                            minArrVal=strength[curLen-1];
//                            lastMin=minArrVal;
//                            lastIndex=curLen-1;
//                        }else {
//                            minArrVal=firstArr[1];
//                            lastMin=minArrVal;
//                            lastIndex=firstArr[0];
//                        }
//                        totalVal=firstArr[2]+strength[curLen-1];
//                        lastTol = totalVal;
//                        firstArr = new int[]{lastIndex, lastMin, lastTol};
//                    }
//
//
//                } else {
//                    int tail = strength[i + curLen - 1];
//                    int head = strength[i - 1];
//
//                    if (tail < lastMin) {
//                        lastMin = tail;
//                        lastIndex = i + curLen;
//                    }
//                    if (lastIndex == i - 1) {
//                        int[] arrVal = minArrVal(Arrays.copyOfRange(strength, i, i + curLen));
//                        lastIndex = arrVal[0] + i;
//                        minArrVal = arrVal[1];
//                        totalVal = arrVal[2];
//                        lastMin = minArrVal;
//                    } else if (lastIndex > i - 1) {
//                        if (tail > lastMin) {
//                            minArrVal = lastMin;
//                            totalVal = lastTol + tail - head;
//                        } else if (tail <= lastMin) {
//                            lastIndex = i + curLen - 1;
//                            minArrVal = tail;
//                            totalVal = lastTol + tail - head;
//                            lastMin = minArrVal;
//                        }
//                    }
//                    lastTol = totalVal;
//                }
//                System.out.println(minArrVal*totalVal);
//                result += minArrVal * totalVal;
//                result %= 1000000000 + 7;
//
//            }
//            curLen++;
//        }
//        return result;
//    }
//
//    //(最小值索引，最小值，总数)
//    private int[] minArrVal(int[] arr) {
//        int min = Integer.MAX_VALUE;
//        int total = 0;
//        int index = -1;
//        for (int i = 0; i < arr.length; i++) {
//            total += arr[i];
//            if (arr[i] <= min) {
//                min = arr[i];
//                index = i;
//            }
//        }
//
//        return new int[]{index, min, total};
//    }

}
