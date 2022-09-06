package com.li.test;

import com.li.domain.Cat;

public class T777 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Cat> catClass = Cat.class;
        Object cat = catClass.newInstance();
        Integer count = count((Integer) cat, 2);
        System.out.println(count);
    }

    public static Integer count(Integer num1, Integer num2) {
        return num1 + num2;
    }
}
