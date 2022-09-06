package com.li.everyday.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * <p>
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2：
 * <p>
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 20
 * expression 由数字和算符 '+'、'-' 和 '*' 组成。
 * 输入表达式中的所有整数值在范围 [0, 99]
 * 通过次数55,294提交次数73,856
 */
public class DiffWaysToCompute241 {
    public static void main(String[] args) {
        DiffWaysToCompute241 main = new DiffWaysToCompute241();
        String s = "2*3-4*5";
        List<Integer> list = main.diffWaysToCompute(s);
        System.out.println(list);
    }

    public List<Integer> diffWaysToCompute(String expression) {
        if (expression == null || expression.length() == 0) {
            return null;
        }
        int length = expression.length();
        int helpIndex = -1;
        ArrayList<Integer> numList = new ArrayList<>();
        ArrayList<Integer> opList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (helpIndex == -1) {
                helpIndex = i;
            }
            if (expression.charAt(i) == '+') {
                numList.add(Integer.valueOf(expression.substring(helpIndex, i)));
                opList.add(1);
                helpIndex = -1;
            } else if (expression.charAt(i) == '-') {
                numList.add(Integer.valueOf(expression.substring(helpIndex, i)));
                opList.add(2);
                helpIndex = -1;
            } else if (expression.charAt(i) == '*') {
                numList.add(Integer.valueOf(expression.substring(helpIndex, i)));
                opList.add(3);
                helpIndex = -1;
            }
        }
        if (helpIndex != -1) {
            numList.add(Integer.valueOf(expression.substring(helpIndex, length )));
        }

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        hashMap.put(0, Arrays.asList(numList.get(0)));
        int helpNum = caculate(numList.get(0), numList.get(1), opList.get(0));
        hashMap.put(1, Arrays.asList(helpNum));
        for (int i = 2; i < numList.size(); i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();

            //拿到前进一格的list
            List<Integer> list1 = hashMap.get(i - 1);
            for (int j = 0; j < list1.size(); j++) {
//                int caculate = caculate(numList.get(i - 1), numList.get(i), opList.get(i - 1));
                int res = caculate(list1.get(j), numList.get(i), opList.get(i - 1));
                arrayList.add(res);
            }

            //拿到前进两格的list
            List<Integer> list2 = hashMap.get(i - 2);
            for (int j = 0; j < list2.size(); j++) {
                int caculate = caculate(numList.get(i - 1), numList.get(i), opList.get(i - 1));
                int res = caculate(list2.get(j), caculate, opList.get(i - 2));
                arrayList.add(res);
            }

            hashMap.put(i, arrayList);
        }


        return hashMap.get(numList.size() - 1);
    }

    private int caculate(int num1, int num2, int opt) {
        switch (opt) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            default:
                break;
        }
        return 0;
    }
}
