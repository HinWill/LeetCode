package DynamicProgramming;



/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Credits:
Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.

题目描述：大意就是有一个小偷偷房间的东西，不能连续偷两个相邻的房间，求最后的最大收益

思路：这道动态规划题主要是对递归关系的分析，找到其中的状态转移，偷取的收益有两种选择，其中robb[n-1]为 n-1 个元素的最大值， num[i]+robb[i-2] 是n-2个元素的最大值加上数组第n个元素的值
因为要求元素不能相邻，所以这里会跳过n-1个元素
在这道题中对状态的定义为：考虑偷取[0......x]范围里的房子（函数的定义）

根据对状态的定义，决定状态的转移：robb(n) = max(robb(n-1), num[n]+robb(n-2))



 */
public class HouseRobber198 {


    public int rob(int[] nums) {

        int len = nums.length;

        if (len == 0) return 0;

        int[] robb = new int[len];
        robb[0] = nums[0];
        for (int i = 1; i < len ; i++){
            robb[i] = Math.max(robb[i-1], nums[i] + (i >= 2 ? robb[i-2] : 0));

        }
        return robb[len - 1];
    }


    public static void main(String[] args) {
        int benefit = new HouseRobber198().rob(new int[]{1});

        System.out.println("benefit = " + benefit);
    }
}
