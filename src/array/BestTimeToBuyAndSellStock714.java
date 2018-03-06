package array;
/*

Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
Buying at prices[0] = 1
Selling at prices[3] = 8
Buying at prices[4] = 4
Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.


题目描述：给出一组股票价格的数组，买卖的次数不限，每次买入必须在卖出之后，而且要收取一定的手续费，求最大的收益方法

思路：这是一道动态规划的问题，这种问题，一般当前的收益与前一天有关，所以只有两种状态就是买和卖，其中hold就是收益 nothold就是买入就是持有股票数最大


买：hold = Math.max(hold, notHold - prices[i]);
卖：notHold = Math.max(notHold, hold + prices[i] - fee);

这里就需要hold 和 nothold的初始值，最终输出hold, 因为最后一天手里是没有股票的


在讨论区还看到了一种非常好的方法，就是使用了栈来求出最大的收益
思路是在栈中保存了[ buy , sell]， 当sell 为0  的时候表示没有卖出
遍历数组，记录当前的价格为price

当栈顶交易sell 为 0 ，并且 price <= buy 将栈顶buy 替换为price
当price >= max(sell, buy+free) 则替换栈顶sell 为 price
否则 将[price , 0] 压栈

当栈元素>1 并且合并栈顶的两组交易可以获得最大收益的时候，将栈顶的两个交易合并
 */



public class BestTimeToBuyAndSellStock714 {


    public int maxProfit(int[] prices, int fee) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int len = prices.length;
        int hold = -prices[0];
        int notHold = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, notHold - prices[i]);
            notHold = Math.max(notHold, hold + prices[i] - fee);
        }

        return notHold;
    }
    public static void main(String[] args) {
        int n = new BestTimeToBuyAndSellStock714().maxProfit(new int[]{3, 1, 2, 8, 4, 9}, 2);

        System.out.println("n = " + n);
    }
}
