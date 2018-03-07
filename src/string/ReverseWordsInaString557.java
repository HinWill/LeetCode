package string;

/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

题目描述：给出一句话，将句子中的所有的单词进行翻转，保留空格的位置

思路：
英文句子分割成一个个单词
将每个单词反转 (以单词中间字母为中心，前后对称位置的字母交换位置)


 */

public class ReverseWordsInaString557 {

    private String flip(String s){
        return new StringBuffer(s).reverse().toString();
    }
    public String reverseWords(String s) {
        StringBuffer sp = new StringBuffer();
        int n = 0, i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                sp.append(flip(s.substring(n, i)) + " ");
                n =  i+1;
            }
        }
        sp.append(flip(s.substring(n, i)));
        return sp.toString();
    }
    public static void main(String[] args) {
        String re = new ReverseWordsInaString557().reverseWords("Let's take LeetCode contest");
        System.out.println("re = " + re);
    }
}
