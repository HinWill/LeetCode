package string;


/*
Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.

给定一个由0和1组成的非空字符串，计算出由相同0和1且0和1分别连续的子串的个数。子串可以重复。

思路：使用2个变量来存储当前数字前的数字连续次数pre以及当前数字的连续次数cur。
如果当前数字与前一个数字连续，则计算出当前数字连续的次数cur，否则统计当前数字之前的数字连续次数pre并令当前数字连续次数cur为1。
接着通过判断统计子数组的个数，如果这时该数字之前的数字连续次数pre大于等于当前数字连续次数cur，则令子数组个数res加1。

如果不理解，按照该代码自行调试一遍，列出每次res加1所对应的子数组方便理解。

例如 “00110”，存在连续子数组“01”，“0011”，“10”。


Your runtime beats 25.49 % of java submissions.

 */
public class CountBinarySubstrings696 {

    public int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i=1;i<s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) curRunLength++;
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }


    public static void main(String[] args) {
        int num = new CountBinarySubstrings696().countBinarySubstrings("0101");
    }

}
