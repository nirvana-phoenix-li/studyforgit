package com.li.everyday.april;

/**
 * User: lishengxiang
 * DateTime: 2022/4/24,13:33
 * Description:
 * 868. 二进制间距
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 * <p>
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 22
 * 输出：2
 * 解释：22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 * <p>
 * 输入：n = 8
 * 输出：0
 * 解释：8 的二进制是 "1000" 。
 * 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：5 的二进制是 "101" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 通过次数32,422提交次数47,436
 */
public class BinaryGap868 {

    public int binaryGap(int n) {
        int maxRet = 0;
        int help = 0;
        boolean flag = false;
        while (n > 0) {
            if (!flag) {
                if ((n & 1) == 1) {
                    flag = true;
                    help = 1;
                }
            } else {
                if ((n & 1) == 1) {
                                 maxRet = Math.max(maxRet, help);
                    help=1;
                } else {
                    help += 1;
                }
            }
            n >>= 1;
        }
        return maxRet;
    }

    public static void main(String[] args) {
        BinaryGap868 main = new BinaryGap868();
        int i = main.binaryGap(22);
        System.out.println(i);
    }
}
