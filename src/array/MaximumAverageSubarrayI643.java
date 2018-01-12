package array;


/*




Given an array consisting of n integers, find the contiguous subarray of given length k
that has the maximum average value. And you need to output the maximum average value.


题目描述：给出一个数组，求出k个长度中子数组的最大值

思路：这道题很容易就超时了，我想了很多降低时间复杂的方法，但是都是超时，首先暴力破解肯定是不行的
然后我想运用递归运算，还是超时

最后看最优解：先求出开始k个元素的和，然后将这个加上后一个减去[i-k]的元素  最终算出最大的和，
也就是  滑动窗口（Sliding Window）的方法
 */



public class MaximumAverageSubarrayI643 {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        double array = new MaximumAverageSubarrayI643().findMaxAverage(nums,4);
        System.out.println("array = " + array);
    }
}
