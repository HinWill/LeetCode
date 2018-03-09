package string;

/*

Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1


题目描述：请实现strStr()函数的功能，就是返回一个子串在另一个字符串中的开始下标，如果没有就返回-1
 */


public class ImplementStr28 {

    public int strStr(String haystack, String needle) {
       //int n = haystack.indexOf(needle);

        for (int i = 0;; i++){
            for (int j = 0;; j++){
                if (j == needle.length()) return i;
                if (i+j == haystack.length()) return -1;
                if (haystack.charAt(i+j) != needle.charAt(j)) break;
            }
        }
    }
    public static void main(String[] args) {
        int n = new ImplementStr28().strStr("hello","ll");

        System.out.println("n = " + n);
    }
}
