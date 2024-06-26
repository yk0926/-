package com.kyong.suixianglu.i动态规划;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/6/26 15:33
 */
//70. 爬楼梯
public class b爬楼梯 {
    public int climbStairs(int n) {
        if(n<3) return n;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
