package array;

/*


Given a binary array, find the maximum number of consecutive 1s in this array.


题目描述：找出一个二进制数组中连续1的最大个数


思路：设立cnt数组，表示在nums[i]处当前连续的1的值，maxn取其最大的值，在遇到nums[i] == 0的时候更新maxn的值。
最后还要更新一下防止最后一个是1.

在最优解中运用了max函数和三元运算符 将代码变得更加简练了，值得学习，但是思路还是一样的

 */


public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {


        int max = 0;
        int m = 0;
        for (int num : nums) {
            m = Math.max(m, max = num == 0 ? 0 : max + 1);
            /*
            if (num == 1){
                ++max;
                if (max > m || max == m) m = max;
            }else {
                max = 0;
            }
            */
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,0,1,1,0,1};
        int max = new MaxConsecutiveOnes485().findMaxConsecutiveOnes(nums);

        System.out.println("max = " + max);

    }
}
