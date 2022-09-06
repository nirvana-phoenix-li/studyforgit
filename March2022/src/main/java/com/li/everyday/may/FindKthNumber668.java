package com.li.everyday.may;

/**
 * 668. 乘法表中第k小的数
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * <p>
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 * <p>
 * 例 1：
 * <p>
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 * <p>
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * <p>
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 * 注意：
 * <p>
 * m 和 n 的范围在 [1, 30000] 之间。
 * k 的范围在 [1, m * n] 之间。
 * 通过次数13,197提交次数23,804
 */
public class FindKthNumber668 {
    public int findKthNumber(int m, int n, int k) {
//        if (k<m*n/2){
//            //从头找
//        }
        int x = 1, y = 1;
        while (k > 0) {
            if (x * y < k) {
                if (x==m&&y==n){
                    return m*n;
                }else if (x==m){

                }
            }
        }
        return 0;
    }
}
