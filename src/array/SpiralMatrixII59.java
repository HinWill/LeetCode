package array;


/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]


题目描述：给一个n 求从1 到 n^2 之间的数字 排列一个螺旋数组

思路：看到这个题就是从螺旋数组中找出数字的排列顺序，总结出以下的规律
数字先向右增大 -》 向下增大 -》向左增大 -》 向上增大
这里牵扯到四个for循环 以及一个while循环，在循环的过程中让其中的四个方向变量分别递增或者递减
这里的下标值还是需要自己多想想 也是这个题的难点

我总觉得这个方法过于繁琐，想通过一个for循环以及一个while循环来解决 但是想了半天没有想出答案
到讨论区发现给出的解答也是我这种思路

 */

public class SpiralMatrixII59 {

    public int[][] generateMatrix(int n) {

        int[][] num = new int[n][n];
        for (int[] ints : num) {

        }
        int sum = 1;
        int r = n-1, l = 0, t = 0, b = n-1;

        while (n - 1 >= 0) {
            for (int i = l; i <= r; i++) {
                num[t][i] = sum++;
            }
            t++;

            for (int i = t; i <= b; i++){
                num[i][r] = sum++;
            }
            r--;

            for (int i = r;i >= l; i--){
                num[b][i] = sum++;
            }
            b--;

            for (int i = b;i >= t; i--){
                num[i][l] = sum++;
            }
            l++;
            n--;
        }
        return num;
    }


    public static void main(String[] args) {


        int[][] sum = new SpiralMatrixII59().generateMatrix(1);

        for (int[] ints : sum) {
            for (int anInt : ints) {
                System.out.print(anInt + " " );
            }
            System.out.println();
        }

    }
}
