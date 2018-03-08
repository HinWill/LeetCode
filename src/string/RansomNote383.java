package string;

/*

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true


题目描述：ransomNote里每个字符出现的次数必须小于或者等于该字符在magazine出现的次数。

思路：我的这种解法比较简单，循环杂志，然后在其中匹配ransomNote中的字符，找到count++ 并且将杂志中的字符修改为为0 最后将count和ransomNote长度进行对比
但是这种方法的效率不高

 */


public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        int count = 0;
        char[] s = magazine.toCharArray();
        for (char c : ransomNote.toCharArray()){
            for (int i = 0; i < s.length; i++) {
                if (c == s[i]){
                    s[i] = '0';
                    count++;
                    break;
                }
            }
        }
        if (count == ransomNote.length()){
            return true;
        }
        return false;

        /*
        这是讨论区中的最佳答案，它的原理就是列出了magazine的字母表，然后算出了出现个数，然后遍历ransomNote，保证有足够的字母可使用，代码非常的清晰，简练
         int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
         */


    }

    public static void main(String[] args) {

        boolean n = new RansomNote383().canConstruct("fffbfg",
                "effjfggbffjdgbjjhhdegh");

        System.out.println("n = " + n);
    }
}
