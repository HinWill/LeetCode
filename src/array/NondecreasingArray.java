package array;


/*


                                665. Non-decreasing Array

Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

所以这道题难在当遇到nums[i] > nums[i+1]的时候，是把nums[i]降为nums[i+1] 还是将nums[i+1]升为nums[i].

如果可行的话，当然是选择优先把 nums[i]降为nums[i+1]，这样可以减少 nums[i+1] > nums[i+2] 的风险。

 */

public class NondecreasingArray {
    public boolean checkPossibility(int[] nums) {

        int count = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]){
                count++;
                if (i > 0 && nums[i + 1] < nums[i - 1]) nums[i + 1] = nums[i];
                else nums[i] = nums[i + 1];
            }
        }

        return count <= 1;
    }

    public static void main(String[] args) {

        int[] nums = {3,4,2,3};
        System.out.println(new NondecreasingArray().checkPossibility(nums));

    }

}
