package string;




/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.


题目描述：给出一段字符串，判断是否为回文字符串，其中包含了标点符号
注意：这道题认为一段空格也为有效的字符

思路：先将字母以及数字添加到另一个字符串中，然后整体进行全部小写处理，然后再判断这段字符串是否为回文字符串
这种方法有点啰嗦，讨论区的方法就简练了很多，用两个指针，分别指向开头和结尾，然后判断两个字符是否相等
如果遇到标点就跳过，如果不相等那么返回false



  if (s.isEmpty()) {
        	return true;
        }

        int head = 0;
        int tail = s.length() - 1;

        char cHead;
        char cTail;

        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);

            // 去除标点符号
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}

        		head++;
        		tail--;
        	}
        }

        return true;
 */
public class ValidPalindrome125 {


    public boolean isPalindrome(String s) {

        StringBuffer su = new StringBuffer();
        for (char c : s.toCharArray()){
            if((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57))
                su.append(c);
        }
        String ss = su.toString();
        su = new StringBuffer(ss.toLowerCase());
        int len = su.length();

        for (int i = 0 ;i<len; i++){
            if (su.charAt(i) != su.charAt(len - i -1)){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        boolean b = new ValidPalindrome125().isPalindrome("0p");

        System.out.println("b = " + b);
    }
}
