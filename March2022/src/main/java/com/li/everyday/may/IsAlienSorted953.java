package com.li.everyday.may;

/**
 * 953. 验证外星语词典
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 * 通过次数24,948提交次数43,973
 */
public class IsAlienSorted953 {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) return true;
        for (int i = 0; i < words.length - 1; i++) {
            if (!verifyDicOrder(words[i], words[i + 1], order)) return false;
        }
        return true;
    }

    private boolean verifyDicOrder(String word1, String word2, String order) {
        if (word1.length() <= word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                if (order.indexOf(word1.charAt(i)) == order.indexOf(word2.charAt(i))) {
                    continue;
                } else if (order.indexOf(word1.charAt(i)) < order.indexOf(word2.charAt(i))) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < word2.length(); i++) {
                if (order.indexOf(word1.charAt(i)) == order.indexOf(word2.charAt(i))) {
                    continue;
                } else if (order.indexOf(word1.charAt(i)) < order.indexOf(word2.charAt(i))) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {
        IsAlienSorted953 main = new IsAlienSorted953();
        String[] words = {"hello","leetcode"};
        String  order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean alienSorted = main.isAlienSorted(words, order);
        System.out.println(alienSorted);


    }

}
