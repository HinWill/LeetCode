package array;

import java.util.Arrays;

/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.


 题目描述：给你一个长度为2n的数组，分组为n个组，取出每个组中的最小值，求这些最小值之和的最大值


 思路：这个题只要你将这个数组在纸上写出来就能很容易的找到方法，
 如何让sum 最大化呢，我们想一下，如果是两个数字，一个很小，一个很大，这样的话，
 取一个小的数字，就浪费了那个大的数字。所以我们要使每一对的两个数字尽可能接近，这样得到的值就尽可能的最大化


 例如 n1 n2 n3 n4 n5 n6 n7 n8 .....

 其中和为最大值的取值为：n1+n3+n5+n7....+2n(n-1)
     和为最小值的取值为：n1+n2+n3+n4...+n(n-1)

 */


public class ArrayPartitionI561 {
    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);
        int sum=0;
        for (int i =0;i<nums.length;i=i+2){
            sum+=nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] nums = {1,4,3,2};

        int sum = new ArrayPartitionI561().arrayPairSum(nums);
        System.out.println("sum = " + sum);
    }
}
