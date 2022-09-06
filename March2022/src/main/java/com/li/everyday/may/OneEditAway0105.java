package com.li.everyday.may;


/**
 * 面试题 01.05. 一次编辑
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * 通过次数49,780提交次数148,840
 */
public class OneEditAway0105 {

    public static void main(String[] args) {
        OneEditAway0105 main = new OneEditAway0105();

//        "teacher"
//        "taches"
        String first = "pals";
        String second = "pal";
        boolean b = main.oneEditAway(first, second);
        System.out.println(b);
    }

    public boolean oneEditAway(String first, String second) {
        int length1 = first.length();
        int length2 = second.length();
        boolean life = true;
        if (Math.abs(length1 - length2) > 1) {
            return false;
        }
        if (length1 == length2) {
            for (int i = 0; i < length1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (life) life = false;
                    else return false;
                }
            }
        } else {
            if (length2 > length1) {
                String temp = second;
                second = first;
                first = temp;
            }
            for (int i = 0; i < second.length(); i++) {
                if (life) {
                    if (first.charAt(i) != second.charAt(i)) {
                        life = false;
                    }
                } else {
                    if (first.charAt(i) != second.charAt(i - 1)) {
                        return false;
                    }
                }
            }
            if (!life && first.charAt(first.length() - 1) != second.charAt(second.length() - 1)) {
                return false;
            }
        }
        return true;
    }
}
