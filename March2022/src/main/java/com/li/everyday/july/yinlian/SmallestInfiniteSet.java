package com.li.everyday.july.yinlian;

import java.util.TreeSet;

public class SmallestInfiniteSet {

    private TreeSet<Integer> myset;

    public SmallestInfiniteSet() {
        myset = new TreeSet<>();
        for (int i =1; i <= 1000; i++) {
            myset.add(i);
        }
    }

    public int popSmallest() {
        int help = 0;
        if (myset.size() != 0) {
            help = myset.pollFirst();
        }
        return help;
    }

    public void addBack(int num) {
        myset.add(num);
    }
}
