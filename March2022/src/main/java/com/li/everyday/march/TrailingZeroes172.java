package com.li.everyday.march;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/3/25
 * Time: 15:02
 * Description:
 * 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * <p>
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 104
 * <p>
 * <p>
 * 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
 * <p>
 * 通过次数121,948提交次数259,192
 */
public class TrailingZeroes172 {
    public static void main(String[] args) {
        TrailingZeroes172 main = new TrailingZeroes172();
//        main.trailingZeroes()
    }

    public int trailingZeroes(int n) {
        int degree = 5;
        int temp = 0;
        while (degree <= 10000) {
            temp += n / degree;
            degree *= 5;
        }
        return temp;
    }
}
