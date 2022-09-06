package com.li.everyday.april;

/**
 * User: lishengxiang
 * DateTime: 2022/4/21,14:23
 * Description:
 * <p>
 * 824. 山羊拉丁文
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * 例如，单词 "apple" 变为 "applema" 。
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * 例如，单词 "goat" 变为 "oatgma" 。
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * 示例 2：
 * <p>
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 150
 * sentence 由英文字母和空格组成
 * sentence 不含前导或尾随空格
 * sentence 中的所有单词由单个空格分隔
 * 通过次数35,666提交次数54,771
 */
public class ToGoatLatin824 {
    public String toGoatLatin(String sentence) {
        StringBuilder outSB = new StringBuilder();
        String[] words = sentence.split(" ");
        for (int i = 1; i <=words.length; i++) {
            String word = words[i-1];
            if (isVowel(word.charAt(0))){
                outSB.append(word);
                outSB.append("ma");
                for (int j = 0; j <i ; j++) {
                    outSB.append("a");
                }
            }else {
                outSB.append(word.substring(1));
                outSB.append(word.substring(0,1));
                outSB.append("ma");
                for (int j = 0; j <i ; j++) {
                    outSB.append("a");
                }
            }
            if (i!=words.length){
                outSB.append(" ");
            }
        }
        return outSB.toString();
    }


    private  boolean isVowel(char input){
        return  input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u'||
        input == 'A' || input == 'E' || input == 'I' || input == 'O' || input == 'U';
    }

    public static void main(String[] args) {
        ToGoatLatin824 main = new ToGoatLatin824();
        String i_speak_goat_latin = main.toGoatLatin("I speak Goat Latin");
        System.out.println(i_speak_goat_latin);
    }
}
