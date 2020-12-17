package DynamicProgramming;

/**
 * @program: Exercises
 * @description: 买卖股票的最佳时机含手续费
 * @author: 宋丽
 * @create: 2020-12-17 19:07
 **/
public class MaxProfit {
    /**
     * 动态规划
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] dp1 = new int[len];
        int[] dp2 = new int[len];
        //不持股
        dp1[0] = 0;
        //持股
        dp2[0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp1[i] = Math.max(prices[i] + dp2[i - 1] - fee, dp1[i - 1]);
            dp2[i] = Math.max(dp1[i - 1] - prices[i], dp2[i - 1]);
        }
        return dp1[len - 1];
    }
}
