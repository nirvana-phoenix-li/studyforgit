package com.li.everyday.july.yinlian;

import java.util.ArrayList;

public class Solution3 {


    public static void main(String[] args) {
        Solution3 main = new Solution3();

        String start1 = "_L__R__R_";
        String target1 = "L______RR";
        String start = "_LL__R__R_";
        String target = "L___L___RR";
        boolean b = main.canChange(start1, target1);
        System.out.println(b);
    }


    public boolean canChange(String start, String target) {
        int length = start.length();
        ArrayList<Integer> slIndex = new ArrayList<>();
        ArrayList<Integer> srIndex = new ArrayList<>();
        ArrayList<Integer> tlIndex = new ArrayList<>();
        ArrayList<Integer> trIndex = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (start.charAt(i) == 'L') slIndex.add(i);
            else if (start.charAt(i) == 'R') srIndex.add(i);
        }

        for (int i = 0; i < length; i++) {
            if (target.charAt(i) == 'L') tlIndex.add(i);
            else if (target.charAt(i) == 'R') trIndex.add(i);
        }
        if (slIndex.size() != tlIndex.size() || srIndex.size() != trIndex.size()) {
            return false;
        }
        char[] charArray = start.toCharArray();
        for (int i = srIndex.size() - 1; i >= 0; i--) {
            Integer indexStart = srIndex.get(i);
            Integer indexTarget = trIndex.get(i);
            if (indexStart > indexTarget) {
                return false;
            } else if (indexStart.equals(indexTarget)) {
                continue;
            } else {
                for (int j = indexStart + 1; j <= indexTarget; j++) {
                    if (charArray[j] == '_') {
                        char c = charArray[j];
                        charArray[j] = charArray[j - 1];
                        charArray[j - 1] = c;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < slIndex.size(); i++) {
            Integer indexStart = slIndex.get(i);
            Integer indexTarget = tlIndex.get(i);
            if (indexStart < indexTarget) {
                return false;
            } else if (indexStart.equals(indexTarget)) {
                continue;
            } else {
                for (int j = indexStart - 1; j >= indexTarget; j--) {
                    if (charArray[j] == '_') {
                        char c = charArray[j];
                        charArray[j] = charArray[j + 1];
                        charArray[j + 1] = c;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }



}
