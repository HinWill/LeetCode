package array;

import java.util.LinkedList;
import java.util.List;

/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


题目描述：给一个数字，求n层帕斯卡三角形。

思路：这道题其实没有什么难的，帕斯卡三角形实质就是杨辉三角，关键是要知道List 的下表也是从0开始的就可以了
杨辉三角的特点：
（1）端点的数为1
（2）每个数等于它上方两数之和
（3）每行数字左右对称，由1开始逐渐变大
（4）第n行的数字有n项
（5）第n行数字之和为2的n-1次方。
 */


public class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new LinkedList<List<Integer>>();

        for (int i = 1;i <= numRows;i++){
            List<Integer> row = new LinkedList<>();
            for (int j = 1;j <= i;j++){
                if (j == 1 || j == i){
                    row.add(1);
                }else {
                    row.add(rows.get(i-2).get(j-2) + rows.get(i-2).get(j-1));
                }
            }
            rows.add(row);
        }
        return rows;
    }

    public static void main(String[] args) {
    }
}
