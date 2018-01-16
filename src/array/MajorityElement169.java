package array;

import java.util.Arrays;

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.


题目描述：给出一个大小为n的数组，找出其中出现次数最多的元素，出现最多的元素次数大于n/2次

思路：看到这个题，想到以前一个题也是找出出现次数最的元素，不过那个是返回次数，这个是返回元素本身
所以这里在查找的过程中要记录元素的值

我的解题过程为：首先将数组排序，然后将记录值Index与数组中的元素进行比较，如果相同增加次数，如果不同减少次数，当记录次数小于等于0的时候，更换记录值index，
这种方法时间复杂度是O(nlogn)，空间复杂度是O(1)。

当然这个题也可以试着用哈希表解决，这种解法是使用一个hash表，键用来存放数组的元素，键对应的值存放元素出现的次数。遍历整个数组，查找它在hash表中是否出现，
如果出现将出现次数加1，如果没有出现，将它插入hash表中，并设置它的出现次数为1。每次遍历到一个元素，判断它的出现次数是否超过了数组长度的一半，
要是超过了就返回该元素。时间复杂度是O(n)，空间复杂度是O(n)。。

*/


public class MajorityElement169 {

    public int majorityElement(int[] nums) {

        int len = nums.length;
        int max = 0;
        int index = nums[0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (max <= 0){
                index = nums[i];
            }
            if (nums[i] == index){
                max ++;
            }else {
                max --;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int num = new MajorityElement169().majorityElement(nums);
        System.out.println("num = " + num);
    }
}
