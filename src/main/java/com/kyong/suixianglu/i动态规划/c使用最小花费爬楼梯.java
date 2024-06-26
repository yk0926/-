package com.kyong.suixianglu.i动态规划;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/26 15:50
 */
//746. 使用最小花费爬楼梯
public class c使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length+1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length+1];
    }
}
