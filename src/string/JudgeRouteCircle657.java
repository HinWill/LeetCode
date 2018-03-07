package string;



/*
Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false


思路：这是一个横纵坐标移动的问题，向左移动x--，向右x++，向上y++，向下y--，最后判断 x == 0 && y == 0即可。
 */


public class JudgeRouteCircle657 {

    public boolean judgeCircle(String moves) {


        /*
        int u = 0, d = 0 ,l = 0 , r = 0;
        for (int i = 0 ;i < moves.length(); i++){
            if (moves.charAt(i) == 'U'){
                u++;
            }
            if (moves.charAt(i) == 'D'){
                d++;
            }
            if (moves.charAt(i) == 'L'){
                l++;
            }
            if (moves.charAt(i) == 'R'){
                r++;
            }
        }
        if (l == r && u == d){
            return true;
        }
        */


        //简化之后的代码
        int x = 0, y = 0;

        for (char c : moves.toCharArray()){
            if (c == 'U') x++;
            else if (c == 'D') x--;
            else if (c == 'L') y++;
            else if (c == 'R') y--;
        }
        return x == 0 && y==0;
    }


    public static void main(String[] args) {
        boolean n = new JudgeRouteCircle657().judgeCircle("LDRRLRUULR");
        System.out.println("n = " + n);
    }
}
