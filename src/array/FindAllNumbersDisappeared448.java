package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:
    Input:
    [4,3,2,7,8,2,3,1]
    Output:
    [5,6]

题目描述：给一个数组，元素的值大于等于1  小于等于n ，有一些元素出现了两次，请找出没有出现在1~n之间的元素。

思路：这道题与 287. Find the Duplicate Number 442. Find All Duplicates in an Array 的思路都是一样的，都是采用的负数标记
因为题中给出了一个很重要的条件，那就是 1<= a[i] <= n，所以说方法就是将每个元素在 1~n 中的位置标记出来，比如4  在1~n 中的位置就是4 所以将a[3] 中的元素取负数
以此类推，通过判断是否为负数来看是否标记过，最终在数组中出现的元素对应1~n 的位置都已经标记出来，通过查找正数的元素也就是数组元素在1~n中没有出现的数

例如：4,3,2,7,8,2,3,1
标记：-4，-3，-2，-7，-8,2,3，-1

其中重复的是2和3 那么它们所占用的是5和6的位置，所以将下标+1就得到缺失的元素



 */


public class FindAllNumbersDisappeared448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        int[] nums = {4,3,2,7,8,2,3,1};
        list = new FindAllNumbersDisappeared448().findDisappearedNumbers(nums);
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }

    }
}
