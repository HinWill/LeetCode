package array;


/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.


题目描述：找出数组中连续子数组之和的最大值

思路：这道题看了很久，首先想到的就是暴力破解，那就是两个for循环，然后遍历数组中的每个子数组找出最大值，
但是这种方法太low了，以前在算法书上印象也看到过类似的题，方法是：

遍历array，对于每一个数字，我们判断，（之前的sum + 这个数字） 和 （这个数字） 比大小，如果（这个数字）
自己就比 （之前的sum + 这个数字） 大的话，那么说明不需要再继续加了，直接从这个数字，开始继续，因为它自己已经比之前的sum都大了。
反过来，如果 （之前的sum + 这个数字）大于 （这个数字）就继续加下去。


但是这个方法的时间很长
Runtime: 19 ms
Your runtime beats 6.61 % of java submissions.


后来看其他人的答案，发现这个题是真的好，解题的方法很灵活，有很多厉害的方法 比如动态分布以及分治算法等等，待我看懂知道再改进下

 */


public class MaximumSubarray53 {

    public int maxSubArray(int[] nums) {

        int sum=0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum  = Math.max(nums[i],nums[i]+sum);
            max = Math.max(max,sum);
        }
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        int n = new MaximumSubarray53().maxSubArray(nums);
        System.out.println("n = " + n);
    }

}
