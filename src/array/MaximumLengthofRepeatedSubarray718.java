package array;


/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
    Input:
    A: [1,2,3,2,1]
    B: [3,2,1,4,7]
    Output: 3
    Explanation:
    The repeated subarray with maximum length is [3, 2, 1].
Note:
    1 <= len(A), len(B) <= 1000
    0 <= A[i], B[i] < 100



    题目描述：给出两个数组，求出题目最长的公共子数组的长度
    思路：使用的是动态规划的思路，首先要找到状态转移，以及转移方程
    状态转移方程：dp[j] = A[i-1] == B[j-1] ? dp[j-1] + 1 : 0
    运用动态规划的思想，当前的状态需要依靠前一个状态的值。也就是说，每次我对比A和B中的字符串时，
    我都会更新目前已经匹配的串的长度，直到对比完A和B两个字符串，得到最终的匹配字符串长度。
    同时，用max去记录每次统计得到的长度最大值。


 */
public class MaximumLengthofRepeatedSubarray718 {

    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length, max = 0;
        int[] dp = new int[m+1];
        for(int i = 1; i <= n; i++)
            for(int j = m; j > 0; j--)
                max = Math.max(max, dp[j] = A[i-1] == B[j-1] ? dp[j-1] + 1 : 0);
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new MaximumLengthofRepeatedSubarray718().findLength(new int[]{1,2,3,2,1},new int[]{1,2,1,4,7}));
    }

}
