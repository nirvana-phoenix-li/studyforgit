package com.li.everyday.march.m6_5;

class TextEditor {

    String myText = "";
    int foxcusIndex = 0;

    public TextEditor() {

    }

    public void addText(String text) {
        int length = myText.length();
        myText = myText.substring(0, foxcusIndex) + text  + myText.substring(foxcusIndex, length);
        foxcusIndex += text.length();
    }

    public int deleteText(int k) {
        int length = myText.length();
        String substring = myText.substring(0, foxcusIndex);
        if (substring.length() < k) {
            myText =  myText.substring(foxcusIndex, length);
            foxcusIndex = 0;
            return substring.length();
        } else {
            int delete = substring.length() - k;
            String substring1 = substring.substring(0, delete);
            String substring2 = myText.substring(foxcusIndex, length);
            foxcusIndex = delete;
            myText = substring1 +  substring2;
            return k;
        }
    }

    public String cursorLeft(int k) {
        int length = myText.length();
        String substring = myText.substring(0, foxcusIndex);
        if (substring.length() < k) {
            foxcusIndex = 0;
            myText =  substring + myText.substring(foxcusIndex, length);

        } else {
            int delete = substring.length() - k;
            foxcusIndex -= k;
            myText = myText.substring(0, delete) +  myText.substring(delete, length);
        }
        if (foxcusIndex < 10) {
            return myText.substring(0, foxcusIndex);
        } else {
            return myText.substring(foxcusIndex - 10, foxcusIndex);
        }
    }

    public String cursorRight(int k) {
        int length = myText.length();
        String substring = myText.substring(foxcusIndex, length);
        if (substring.length() < k) {
            foxcusIndex = length;
            myText =  myText.substring(0, foxcusIndex)+substring ;
        } else {
            int add = substring.length() - k;
            foxcusIndex += k;
            myText = myText.substring(0, add) + myText.substring(add, length);
        }
        if (foxcusIndex < 10) {
            return myText.substring(0, foxcusIndex);
        } else {
            return myText.substring(foxcusIndex - 10, foxcusIndex);
        }
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        Object[][] objects = {{}, {13}, {17}, {2}, {"woyrgb"}, {1}, {20}, {2}, {"liwisjrgylvpm"}, {1}, {"psoliwmahgdnpbc"}, {"vlxhvfzqbynxx"}, {"thwmxwhaltkooqim"}, {"yfok"}, {"qehvtuxvhtkibcjgaqsw"}, {"zsmifuiluczhmwntknav"}, {18}, {16}, {"dfjevkudebhnnco"}, {"wtokffbupoglawqjmhui"}, {"zoxehzvciyofszbcs"}, {"fwvk"}, {20}, {"atwopvcufhyxj"}, {"klasejwyppmsq"}, {7}, {"qdklzkhaczzblijn"}, {13}, {3}, {"lck"}, {"uhbhtqybmtsadxhi"}, {"dontqizlxn"}, {"tpbzrr"}, {2}, {13}, {"souphmty"}, {"m"}, {"pvnvm"}, {16}, {"ektkj"}, {10}, {"lno"}, {13}, {9}, {3}, {"cpchcxhmjdnup"}, {12}, {"pyjjjbupvdbrzbhvafiz"}, {"ihyibjfsophrm"}, {2}, {19}, {7}, {18}, {"dbsepzzbxibge"}, {19}, {1}, {12}, {"h"}, {6}, {3}, {7}, {16}, {9}, {8}, {"udvagithsllh"}, {4}, {"l"}, {"bq"}, {"adevnydcsqdmgbv"}, {8}, {"uqlgoo"}};
        
    }
}