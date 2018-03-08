package string;

/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5



题目描述：给出一句话，输出最后一个单词的长度

思路：这道题并不难，但是有特殊情况，比如"a b "这种，这里先是将字符串用空格进行分割，
然后输出字符串数组中最后一个字符串的长度

讨论区有很多的简练的写法，比如注释用一行代码 显示去除首尾的空格，然后减去最后一次空格出现的下标
就是最后一个单词的长度了
 */


public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        String[] su = s.split(" ");
        int n = su.length;

        if (n != 0){
            int len = su[n-1].length();
            return len;
        }else {
            return 0;
        }
        /*
            return s.trim().length()-s.trim().lastIndexOf(" ")-1;
         */

    }


    public static void main(String[] args) {
        int n = new LengthOfLastWord58().lengthOfLastWord("          ");
        System.out.println("n = " + n);
    }
}
