package com.li.everyday.march;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/3/31
 * Time: 11:01
 * Description:
 * 728. 自除数
 * 自除数 是指可以被它包含的每一位数整除的数。
 * <p>
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 * <p>
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * 示例 2:
 * <p>
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= left <= right <= 104
 * 通过次数50,348提交次数64,861
 */
public class SelfDividingNumbers728 {
    public static void main(String[] args) throws Exception {
        SelfDividingNumbers728 main = new SelfDividingNumbers728();
        List<Integer> list = main.selfDividingNumbers(1, 22);
        System.out.println(list);


    }

    /**
     * 
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int help = i;
            boolean flag = true;
            while (help > 0) {
                int i1 = help % 10;
                if (i1 != 0) {
                    if (i % i1 != 0) {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
                help /= 10;
            }
            if (flag) {
                list.add(i);
            }
        }
        return list;
    }
}
