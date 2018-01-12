package array;

import java.util.Arrays;


/*

Given an integer array, find three numbers whose product is maximum and
output the maximum product.

Note:
The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.


题目描述：给一个整数数组，找到三个整数之积最大的值并输出

思路：这道题我上去一看这不是非常简单，然后看了一下注意，原来还有负数，差点踩坑

我的思路是首先将数组排序，然后判断最大值的正负，如果为正，那么只需要比较最小的两个值和第二大以及第三大之间积的大小，如果为0那么直接返回0
如果最大值为负数，那么只需要返回最后三个数的积就可以了

时间复杂度为 nlog2 n

通过的时间比较长，所以看了最优解，方法跟414 题的思路一样  在循环中记录最大的三个值 以及最小的两个值
这里的只找最小的两个值需要make sense，
例如[min1 =-9, min2=-8, max3=1, max2=2, max1=5]。我们需要使用的唯一条件min1 and min2是这两个是否定的。
我们必须得到一个积极的结果，只有一个解决方案：-*-*+ (min1*min2*max1)，然后比较+*+*+ (max1*max2*max3)找到最大的一个。
在对输入数组进行排序并讨论特殊情况之后，将很容易想到：
    1、所有数字> 0 || 一个数字<0且其余> 0
    2、两个或更多<0且其余> 0
    3、所有数字<0
 */



public class MaximumProductOfThreeNumbers628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int a = nums[0], b = nums[1], c = nums[2];
        int d = nums[len - 3], e = nums[len - 2], f = nums[len - 1];
        if (f > 0) {
            return Math.max(f * a * b, f * d * e);
        } else if (f == 0) {
            return 0;
        } else {
            return f * d * e;
        }

        /*
         int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
        */


    }


    public static void main(String[] args) {
        int[] nums = {9,1,5,6,7,2};

        int n = new MaximumProductOfThreeNumbers628().maximumProduct(nums);
        System.out.println("n = " + n);
    }
}
