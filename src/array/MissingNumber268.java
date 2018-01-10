package array;

/*

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.


找出给定数组中缺失的那个元素

这道题其实有很多中方法，但是我想是数组转化为列表，然后用列表的判断是否存在，用for循环进行判断
下面的解法是将给定数组的和算出来，然后减去数组中的元素，得到的就是缺失的元素

还有一种解法是利用位的运算，但是我现在还是看的不太明白
 int xor = 0, i = 0;
	for (i = 0; i < nums.length; i++) {
		xor = xor ^ i ^ nums[i];
	}

	return xor ^ i;

 */

public class MissingNumber268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for(int num : nums){
            sum -= num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(new MissingNumber268().missingNumber(nums));
    }
}
