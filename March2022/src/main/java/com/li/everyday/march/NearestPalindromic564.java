package com.li.everyday.march;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/3/2
 * Time: 16:24
 * Description:
 * 564. 寻找最近的回文数
 * 给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。
 * <p>
 * “最近的”定义为两个整数差的绝对值最小。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = "123"
 * 输出: "121"
 * 示例 2:
 * <p>
 * 输入: n = "1"
 * 输出: "0"
 * 解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n.length <= 18
 * n 只由数字组成
 * n 不含前导 0
 * n 代表在 [1, 1018 - 1] 范围内的整数
 * 通过次数14,625提交次数54,147
 */
public class NearestPalindromic564 {
    public static void main(String[] args) {
        NearestPalindromic564 main = new NearestPalindromic564();
        String input = "1213";
        String s = main.nearestPalindromic(input);
        System.out.println(s);
    }

    public String nearestPalindromic(String n) {
        if (n == null || n.length() == 0) return n;
        int length = n.length();
        if (length == 1) {
            return String.valueOf(Integer.parseInt(n) - 1);
        }
        if (Integer.parseInt(n)==10){
            return "9";
        }
        char[] charArray = n.toCharArray();
        for (int i = (length + 1)/ 2 ; i <length; i++) {
            int frist = charArray[length - i - 1] - 48;
            charArray[i] = (char) (frist + 48);
        }
        return String.valueOf(charArray);
    }

}
