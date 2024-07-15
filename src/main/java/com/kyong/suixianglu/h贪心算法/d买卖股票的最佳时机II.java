package com.kyong.suixianglu.h贪心算法;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/7/15 15:42
 */
//122.买卖股票的最佳时机 II
public class d买卖股票的最佳时机II {
    //贪心
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }


    // 动态规划
    public int maxProfit2(int[] prices) {
        // [天数][是否持有股票]
        int[][] dp = new int[prices.length][2];

        // base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
