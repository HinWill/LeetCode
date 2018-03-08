package string;

public class ValidParentheses20 {

    public boolean isValid(String s) {
        int n = 0;
        for (int i = 0 ; i < s.length()-1;i=i+2){
            char c = s.charAt(i);
            char u = s.charAt(i+1);
            n = 0;
            if ((c == '(' && u == ')') || (c == '{'&& u == '}' )|| (c == '[' && u == ']')){
                n = 1;
            }
            if (n == 0){
                break;
            }
        }
        return n == 1;
    }

    public static void main(String[] args) {

        boolean b = new ValidParentheses20().isValid("(");

        System.out.println("b = " + b);
    }

}
