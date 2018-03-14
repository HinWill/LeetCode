package DynamicProgramming;


/*

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps.
 You need to find minimum cost to reach the top of the floor,
 and you can either start from the step with index 0, or the step with index 1.

Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].


题目描述：这道题可以简单的讲，就是爬楼梯，每次只能爬一层或者是两层，求最后爬到顶层所消耗最少

思路：这是一道典型的动态规划的问题，一般想到的方法是，申请一个数组保存爬到每层所需要消耗的值，
因为每次可以走1层或者2层，并且可以从0或者从1开始，所以可以得到dp[0]为0，dp[1]为0。从2开始，
dp[i]可以由通过dp[i-2]走2层或者通过dp[i-1]走一层到达，而这i-2和i-1层所要花费的值分别为cost[i-2]和cost[i-1]，
所以，dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])

当然也通过两个变量存储前一阶和齐前两阶的消耗，这样可以把空间复杂度从O(n)降低到O(1)

 */
public class MinCostClimbingStairs746 {

    public int minCostClimbingStairs(int[] cost) {
        int d0 = 0;
        int d1 = 0;
        int d2 = 0;

        for (int i = 2; i < cost.length +1; i++){
            d0 = Math.min(d1 + cost[i-1], d2 + cost[i-2]);
            d2 = d1;
            d1 = d0;
        }
        return d0;
    }
    public static void main(String[] args) {

        int n = new MinCostClimbingStairs746().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});

        System.out.println("n = " + n);
    }
}
