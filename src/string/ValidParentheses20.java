package string;


/*


Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


题目描述：给出一组括号，括号是不是一一对应的，比如 ( )  或者 { } [ ] ( )算合法的括号，（] 或者 ( [ ) ] 都不合法。

思路：这道题用loop 就非常的麻烦，但是用栈就是非常的简单，其实这道题就是考察的对栈的使用
具体的思路如下：将前括号压入栈中，如果栈顶遇到与之相匹配后括号就弹出，最后检查栈是否为空，如果为空那么就说明全部为合法的括号

导论区的写法更加简练

Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();


 */

import java.util.Stack;

public class ValidParentheses20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        stack.push(arr[0]);

        for (int i = 1; i < s.length(); i++){
            if (!stack.isEmpty() && isMatch(stack.peek(),arr[i])){
                stack.pop();
            }else {
                stack.push(arr[i]);
            }
        }

        return stack.isEmpty();


    }

    public boolean isMatch(char a, char b){
        return (a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}');
    }

    public static void main(String[] args) {

        boolean b = new ValidParentheses20().isValid("()");

        System.out.println("b = " + b);
    }

}
