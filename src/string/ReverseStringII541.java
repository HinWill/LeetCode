package string;


/*
Given a string and an integer k, you need to reverse the first k characters for every 2k
characters counting from the start of the string. If there are less than k characters left,
reverse all of them. If there are less than 2k but greater than or equal to k characters,
 then reverse the first k characters and left the other as original.

题目描述：输入一个字符串s和一个整数k，使得前k个字符串翻转，后k个字符串保持不变，如此不断处理整个字符串，直到达到字符串尾部。


实现方法：
1.先写一个函数void reverse(string &s,int start,int end)；实现字符串s从start到end的翻转。
2.然后需要一个变量存下一次的终止位置，终止位置取当前位置+k-1 和 字符串尾。
3.另外还需要判断的是，在翻转的时候，当end大于字符串的长度时，则应该翻转start到s.length()-1之间的字符串。

我的代码多考虑了剩余字符串长度的判断
 */

public class ReverseStringII541 {
    public String reverseStr(String s, int k) {

        char[] arr = s.toCharArray();
        int len = arr.length;

        int i = 0;

        while (i < len){
            int  j = Math.min(i+k-1,len-1);

            swap(arr, i, j);

            i += 2*k;
        }
       return String.valueOf(arr);
    }
    public void swap(char[] str , int m, int n){
        while (m < n){
            char t= str[m];
            str[m++] = str[n];
            str[n--] = t;
        }
    }
    public static void main(String[] args) {
        String a = "abc";
        a = new ReverseStringII541().reverseStr(a ,3);
        System.out.println("a = " + a);
    }
}
