package string;


/*
                                                        686. Repeated String Match

Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").


题目描述：给你两个字符串A和B，求A要最少重复几次才能让B成为它的子串。（这里有个坑，就是A本身已经包含了1次）

思路：
这个题最重要的是对于A字符串重复次数的理解，这里分为三个阶段
首先是要保证重复的长度刚好大于B的长度，这时候判断A是否刚好包含B

如果不包含，再重复一次，这个重复很微妙，因为这一次的重复刚好能够保证在重复后的A中能够索引一遍B的长度，
如果这时候还没有找到，就返回-1，
因为在上面的重复之后str的长度是大于等于B的长度的，这个是为了保证在长度相等的时候还没有找到B，
所以再A重复一次，保证重复的长度肯定是大于B的，

 */

public class RepeatedStringMatch686 {
    public int repeatedStringMatch(String A, String B){
        int count = 0;
        StringBuffer str = new StringBuffer();
        while(str.length() < B.length()){
            str.append(A);
            count++;
        }
        if (str.toString().contains(B)) return count;
        if (str.append(A).toString().contains(B)) return ++count;
        return -1;
    }
    static  public void main(String[] args){
        System.out.println(new RepeatedStringMatch686().repeatedStringMatch("abcd","cdabcdab"));
    }

}
