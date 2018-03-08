package string;

/*

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

题目描述：给出一个字符串，找出第一个不重复字符的下标

思路：这里注意中给出了一个重要的条件，字符串中只出现小写字母，所以自然想到做一个字母表的映射，来保存字符串中
每次字母出现的次数，然后再扫描一遍字符串，判断第一个出现次数为1的字母，并返回其下标，如果扫描结束后还没有返回
说明字符串中的字母都为重复字母

同时讨论区还有一种时间复杂度很低的方法，就是使用的快慢指针的方法，他的思路是：使用一个慢指针指向当前唯一的字符，
快指针用来扫描字符串，当快指针和慢指针同时指向同一个字母的时候，慢指针移向下一个唯一且没有被访问的字母 时间复杂度为O(n)

 */

public class FirstUniqueCharacterInAString387 {

    public int firstUniqChar(String s) {

        int freq[] = new int[26];

        for (int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i<s.length(); i++){
            if (freq[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n = new FirstUniqueCharacterInAString387().firstUniqChar("loveleetcode");
        System.out.println("n = " + n);
    }
}
