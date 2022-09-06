package com.li.everyday.march;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/3/28
 * Time: 15:44
 * Description:
 * 693. 交替位二进制数
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * 示例 3：
 * <p>
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 231 - 1
 * 通过次数52,715提交次数81,380
 */
public class HasAlternatingBits693 {
    public static void main(String[] args) {
        HasAlternatingBits693 main = new HasAlternatingBits693();
        boolean b = main.hasAlternatingBits(21);
        System.out.println(b);
    }

    public boolean hasAlternatingBits(int n) {
        int help = -1;
        while (n > 0) {
            if (help == -1) {
                help = n % 2;
            } else {
                int i = help ^ (n % 2);
                if (i == 0) {
                    return false;
                } else {
                    help = help ^ 1;
                }

            }
            n >>>= 1;
        }
        return true;
    }
}
