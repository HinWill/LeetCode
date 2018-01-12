package array;




/*
Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number.
The time complexity must be in O(n).

题目描述：给你一个非空数组，求这个数组第三个最大的数，如果不存在就返回最大的数，要求时间复杂度为O(n)


思路：刚开始就踩着坑了，要求的是第三个最大的是，也就是在不重复的情况下第三个最大，
还有就是要求了时间复杂度，所以肯定是不能够排完序后去查找，后来想到的方法就是用三个
标记过的数来存储数组中的前三个最大的数，通过判断是否为空或者用整数的最小值进行标记
然后通过三层比较，最终求出第三最大的值


 */
public class ThirdMaximumNumber414 {
    public int thirdMax(int[] nums) {

        Integer n1 = null;
        Integer n2 = null;
        Integer n3 = null;

        for (Integer num : nums) {
            if (num.equals(n1) || num.equals(n2) || num.equals(n3)) continue;
            if (n1 == null || num > n1){
                n3 = n2;
                n2 = n1;
                n1 = num;
            }
            else if(n2 == null || num > n2){
                n3 = n2;
                n2 = num;
            }else if(n3 == null || num > n3){
                n3 = num;
            }

        }
        return n3 == null ? n1 : n3;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};

        int num = new ThirdMaximumNumber414().thirdMax(nums);
        System.out.println("num = " + num);

    }
}
