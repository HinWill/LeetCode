package array;



/*

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 这道题我上来的想法是第一次遍历，把不等于0的元素保存到另外一个数组中。
第二次遍历，先把已保存不等于0的元素依次赋值到nums，然后把nums剩下的元素空位都赋值0

当然这种方法的时间复杂度为O(2n)

在优解中，其实两种方法的思想都是差不多的，都是将不等于0的元素放到数组的前面，用一个变量进行标记位置
但是第二个方法是将两个元素进行交换、第一个直接将元素放到数组前，然后再将后面的元素赋值为0，时间复杂度都为O(n)



 */



public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
                j++;
            }
        }
    }
    public void moveZeroess(int[] nums){
        if (nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        new MoveZeroes().moveZeroess(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }
}
