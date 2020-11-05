package DynamicProgramming;

/**
 * @program: Exercises
 * @description: 零钱兑换
 * @author: 宋丽
 * @create: 2020-11-05 19:43
 **/
public class CoinChange {
    /**
     * 动态规划
     * f[x] = min{f[x-coins[i]]+1,...,f[x]}
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        count[0] = 0;
        for(int i = 1 ; i <= amount ; i++){
            count[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && count[i - coin] != Integer.MAX_VALUE) {
                    count[i] = Math.min(count[i - coin] + 1, count[i]);
                }
            }
        }
        if(count[amount] == Integer.MAX_VALUE){
            count[amount] = -1;
        }
        return count[amount];
    }
}
