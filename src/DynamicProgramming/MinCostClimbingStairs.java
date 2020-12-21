package DynamicProgramming;

/**
 * @program: Exercises
 * @description: 使用最小花费爬楼梯
 * @author: 宋丽
 * @create: 2020-12-21 18:03
 **/
public class MinCostClimbingStairs {
    /**
     * 动态规划
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2 ; i < cost.length ; i++){
            dp[i] = Math.min(dp[i - 1],dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1],dp[cost.length - 2]);
    }

    /**
     * 类似题目
     * 爬楼梯
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n < 2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 斐波那契数列
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        int a = 0;
        int b = 1;
        int res = 0;
        for(int i = 2 ; i <= n ; i++){
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }
}
