package com.fosuchao.bytedance.enterprise;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * 309. 最佳买卖股票时机含冷冻期
 */

public class Num309 {

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // dp[i][0] 持有
        // dp[i][1] 卖出
        // dp[i][2] 冷冻期

        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
            dp[i][2] = dp[i - 1][1];
        }
        return dp[prices.length - 1][1];
    }
}
