package com.li.everyday.april;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/4/7
 * Time: 13:35
 * Description:
 * 796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * <p>
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * <p>
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 * 通过次数47,555提交次数78,410
 */
public class RotateString796 {
    public static void main(String[] args) {
        RotateString796 main = new RotateString796();
        String string1 = "abcde";
        String string2 = "abcde";
        boolean b = main.rotateString(string1, string2);
        System.out.println(b);
    }

    public boolean rotateString(String s, String goal) {
        int length = s.length();
        int length2 = goal.length();
        if (length != length2) return false;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                boolean flag = true;
                for (int j = 0; j < length; j++) {
                    if (s.charAt((i + j) % length) != goal.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
}
