package com.li.everyday.april;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/4/11
 * Time: 15:37
 * Description:
 * 357. 统计各位数字都不同的数字个数
 * 给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：91
 * 解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 8
 * 通过次数45,563提交次数78,846
 */
public class CountNumbersWithUniqueDigits357 {
    public static void main(String[] args) {
        CountNumbersWithUniqueDigits357 main = new CountNumbersWithUniqueDigits357();
        int i = main.countNumbersWithUniqueDigits(3);

        System.out.println(i);
    }

    public int countNumbersWithUniqueDigits(int n) {
        int res = 1;
        while (n > 0) {
            int temp = n;
            int tempMemory = 1;
            for (int i = 1; i <= temp; i++) {
                if (i == 1) {
                    tempMemory *= 9;
                    continue;
                }
                tempMemory *= 11 - i;
            }
            res += tempMemory;
            n--;
        }
        return res;
    }
}
