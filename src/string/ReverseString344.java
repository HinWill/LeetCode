package string;

import java.util.Arrays;
/*
Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

题目描述：将给出的字符串翻转

实现的方法有很多，栈，递归，异或运算，或者直接使用java 中stringbuffer中的reverse()方法
                                    return new StringBuffer(s).reverse().toString();


 */
public class ReverseString344 {

    public String reverseString(String s) {

        char[] n = new char[s.length()];
        int j = 0, i = s.length()-1;
        for (char a : s.toCharArray()){
            n[j] = s.charAt(i);
            j++;
            i--;
        }
        return new String(n);
    }


    public static void main(String[] args) {
        String s = new ReverseString344().reverseString("hello");
        System.out.println("s = " + s);
    }
}
