package com.li.test;

/**
 * User: lishengxiang
 * DateTime: 2022/4/18,17:57
 * Description:
 */
public class SimpleTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            sb.append(i);
        }
        long s2 = System.currentTimeMillis();
        long s3 = System.currentTimeMillis();

    }
}
