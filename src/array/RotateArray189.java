package array;

/*
189. Rotate Array

Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].



看到这道题就想到了以前做字符串旋转是一样的方法，其中比较好的解就是三步反转，这样能比使用将一个一个元素移动的时间复杂度低很多，
若是使用上述一个一个移动，那么对于长度为n的数组，假设需要移动m个元素，那么总共需要m*n次操作，同时还需要设立一个变量来保存第一个元素，
那么时间复杂度为O(mn),空间复杂度为O(1)。

 */


public class RotateArray189 {

    public void rotate(int[] nums, int k) {

        int m = nums.length;
        k %= m;

        reverserString(nums, 0, m-k-1);
        reverserString(nums, m-k, m-1);
        reverserString(nums, 0, m-1);
    }




    public void reverserString(int[] nums, int n, int m){
        while(n < m){
            int num = nums[n];
            nums[n++] = nums[m];
            nums[m--] = num;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};

        new RotateArray189().rotate(nums,3);

        for (int num : nums) {
            System.out.println("num = " + num);
        }

    }







}
