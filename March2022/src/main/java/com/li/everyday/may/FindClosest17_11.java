package com.li.everyday.may;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 面试题 17.11. 单词距离
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 * <p>
 * words.length <= 100000
 * 通过次数29,962提交次数41,577
 */
public class FindClosest17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        HashMap<String, List> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (hashMap.get(words[i]) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(words[i], list);
            }else {
                hashMap.get(words[i]).add(i);
            }
        }

        

        return 0;
    }
}
