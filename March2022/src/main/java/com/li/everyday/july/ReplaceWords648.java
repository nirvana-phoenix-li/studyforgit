package com.li.everyday.july;

import java.util.ArrayList;
import java.util.List;

/**
 * 648. 单词替换
 * 在英语中，我们有一个叫做 词根(root) 的概念，可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典 dictionary 和一个用空格分隔单词形成的句子 sentence。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 * <p>
 * <p>
 * 通过次数47,958提交次数75,342
 */
public class ReplaceWords648 {

    public static void main(String[] args) {
        ReplaceWords648 main = new ReplaceWords648();

//        dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
//["a", "aa", "aaa", "aaaa"]
//        "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"


        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("catt");
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");

        String sentence = "the cattle was rattled by the battery";
        String s = main.replaceWords(dictionary, sentence);
        System.out.println(s);
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            boolean isChange = false;
            String possibleKey = null;
            for (int j = 0; j < dictionary.size(); j++) {
                //compare the long sentence is contain the short
                int index = split[i].indexOf(dictionary.get(j));
                if (index == 0) {
                    if (possibleKey == null || possibleKey.length() > dictionary.get(j).length()) {
                        possibleKey = dictionary.get(j);
                    }

                    isChange = true;
                }
            }
            if (!isChange) {
                sb.append(split[i]);
            }else {
                sb.append(possibleKey);
            }
            //in order to avoid last char is a space
            if (i != split.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
