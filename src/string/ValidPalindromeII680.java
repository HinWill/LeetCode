package string;

/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.


题目描述：给出一个字符串，最多去掉一个字符，判断是否为回文字符串

思路：首尾字符进行判断，如果遇到不同的，跳过一个字符进行判断，首部向右一位或者尾部向左一位，然后对剩下的字符串进行判断
 */

public class ValidPalindromeII680 {


    public boolean validPalindrome(String s) {

        int l = 0, r = s.length()-1;

        while (l < r){
            if (s.charAt(l) != s.charAt(r) ) return isPalindrome(s,l,r+1) || isPalindrome(s,l-1,r);
            l++;
            r--;
        }

        return true;
    }

    public boolean isPalindrome(String s,int l,int r){
        while (++l < --r){
            if (s.charAt(l) != s.charAt(r)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean b = new ValidPalindromeII680().validPalindrome("a   ");
        System.out.println("b = " + b);
    }
}
