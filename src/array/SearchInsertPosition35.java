package array;



/*
Given a sorted array and a target value, return the index if the target is found. If not,
 return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
Input: [1,3,5,6], 5
Output: 2

题目描述：给出一个有序数组以及一个整数，如果在数组中存在，返回索引，如果不存在那么返回插入有序数组中的索引

思路：一看到这个有序数组中查找就想到了二分查找，我估计这个题也主要是考查的二分查找算法，但是好长时间没有用了就忘记了，
写了一个特别啰嗦的，都不想提交，然后看了一下别人的，也就是第二个方法，简练了很多。

这里主要再重新总结一下二分查找的相关知识：
二分算法的适用条件就是要求数组是有序的，只要通过不断缩小包含T的数据范围，那么最终就可以找到数T，其过程如下：
1、一开始，数据范围覆盖整个数组
2、将数组的中间项与T进行比价，如果T比数组的中间项小，则到数组的前半部分查找，反之到后半部分查找
3、这样每次查找都可以排除一半的元素，相当于范围缩小了一半，这样反复比较，反复缩小范围，最终会在数组中找到T，或者确定T不在数组中

其实在实际中自己写二分查找很容出现bug，其中有两点需要注意：
1、判断循环体是否终止的语句的编写
2、边界值left、right和区间值这三个地方要保持一致

这个保持一致很重要，比如：如果令right=n-1，则while循环的循环条件为left<=right 从而更新右边界位置的时候right=middle-1
而如果令right=n,则循环的循环条件为left<right 从而更新右边边界位置的时候为right = middle,同时middle的计算不能写在循环的外面，
不然无法更新



 */

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        /*
        1
        if (target < nums[0]) return 0;
        int i,len = nums.length;
        for (i = 1; i < len; i++) {
            if (nums[i] == target) return i;
            if (target > nums[i-1] && target < nums[i]) return i;
        }
        if (target > nums[len-1]) return len;
        return 0;
        */

        /*
        2
        int i = 0;
        int j = 0;
        for(i = 0; i< nums.length; i++){
            if(target == nums[i]) {
                return i;
            }
        }
        for(j = 0; j< nums.length; j++){
            if(nums[j]> target){
                return j;
            }
        }
        return j;
        */

        int start = 0;
        int end = nums.length-1;

        while(start<=end) {
            int mid = start + (end-start) / 2;
            if(nums[mid]<target) {
                start = mid + 1;
            } else if(nums[mid]>target) {
                end = mid - 1;
            } else
                return mid;
        }

        return start;


    }

    public static void main(String[] args) {

        int[] nums = {1,3,5,6};

        int num = new SearchInsertPosition35().searchInsert(nums,2);

        System.out.println("num = " + num);
    }
}
