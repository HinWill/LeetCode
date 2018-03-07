package string;


/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.


题目描述：给一个字符串，当所有字母为大写或者小写以及首字母大写时返回true 其余的返回false

思路：
判断word[0]和word[1]的大小写，如果word[0]是小写，那后面必须是小写，
如果word[0]是大写word[1]是小写，那后面也必须是小写，
如果word[0]是大写word[1]也是大写那么后面必须都是大写～

        65～90号为26个大写英文字母，97～122号为26个小写英文字母
 */
public class DetectCapital520 {
    public boolean detectCapitalUse(String word) {
        int n = 0, l = word.length();
        for (char c : word.toCharArray()){
            if (c < 91){
                n++;
            }
        }
        return l == n || n == 0 || (n == 1 && word.charAt(0) < 97);

    }


    public static void main(String[] args) {
        boolean n = new DetectCapital520().detectCapitalUse("ffffffffffffffffffffF");
        System.out.println("n = " + n);
    }
}
