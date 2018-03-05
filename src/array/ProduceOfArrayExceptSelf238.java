package array;

/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)

 题目描述：给出一个数组，返回一个除当前元素之外元素之积的数组
 要求：不能使用除法，限制时间复杂度为0(n),并且使用恒定的空间复杂度
 思路：看到这个题有点眼熟，知道是使用当前元素的前后个元素之积相乘，想到这里思路也就出来了。举个例子
              数组：{ n1,n2,n3,n4}
 那么所要求的数组为：{n2*n3*n4, n1*n3*n4, n1*n2*n4, n1*n2*n3}
        可以看做是：
        {       1，     n1,   n1*n2,   n1*n2*n3}  -> a1
       *{n2*n3*n4,   n3*n4,      n4,   1}         -> a2

       但是这里只需要创建一个数组，使用一个变量存储数组a2的值就可以了

 */


public class ProduceOfArrayExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        output[0] = 1;

        for (int i = 1; i < output.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }

        /*
        int n = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= n;
            n *= nums[i];
        }
        */
        //这里还可以省去一个变量，直接使用output[0] 来进行存储每次计算的结果值
        for (int i = nums.length - 1; i > 0; i--) {
            output[i] *= output[0];
            output[0] *= nums[i];
        }

        return output;
    }
    public static void main(String[] args) {
        int[] output = new ProduceOfArrayExceptSelf238().productExceptSelf(new int[]{2, 3, 4});
        for (int i : output) {
            System.out.println("i = " + i);
        }
    }
}
