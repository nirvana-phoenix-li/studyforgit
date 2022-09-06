package com.li.test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Just4Fun {
    public static void main(String[] args) {
        List<String> list=null;
        Set<String> collect = list.stream().collect(Collectors.toSet());
        System.out.println(collect);
    }

}
