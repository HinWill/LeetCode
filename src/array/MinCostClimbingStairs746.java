package array;

/*

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
and you can either start from the step with index 0, or the step with index 1.


题目描述：给你一些数，代表走每阶楼梯的代价，你可以一次走一步或两步，问你走到楼顶，最少的消耗代价

思路：这是一道动态规划的问题，需要思考每一步的子问题是什么，这个子问题又能够由上一步或者那些子问题解决
子问题空间：total_cost记录到达第i个台阶的totalcost（前i个台阶的总cost）；
关联问题变量与子问题：只有两种状态，从（i-1）走一阶到达i，花费为total_cost[i-1]+cost[i-1]；或从（i-2）走两阶到达i，花费为total_cost[i-2]+cost[i-2]。
自底向上计算：只有一个台阶和没有台阶时总花费为0.

时间复杂度：O(n)


 */



public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int cost_i_1=0,cost_i_2=0;
        int n=cost.length;
        int total_cost=0;
        if(n==1||n==0)
        {
            return 0;
        }
        for(int i=2;i<=n;i++)
        {
            total_cost=Math.min(cost[i-1]+cost_i_1,cost[i-2]+cost_i_2);
            cost_i_2=cost_i_1;
            cost_i_1=total_cost;
        }
        return total_cost;
    }


    public static void main(String[] args) {

        int[] nums = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        int num = new MinCostClimbingStairs746().minCostClimbingStairs(nums);

        System.out.println("num = " + num);
    }

}
