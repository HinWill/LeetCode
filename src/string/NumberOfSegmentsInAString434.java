package string;

/*

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5

题目描述：给出一段字符串，求出字符串中的单词数目

思路：除了开头的单词之外  其他的都是单词之前有空格，根据这个特征可以算出句子中的单词数目

 */

public class NumberOfSegmentsInAString434 {

    public int countSegments(String s) {
        int res=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)!=' ' && (i==0 || s.charAt(i-1)==' '))
                res++;
        return res;
    }


    public static void main(String[] args) {

        int n = new NumberOfSegmentsInAString434().countSegments(", , , ,        a, eaefa");

        System.out.println("n = " + n);
    }
}
