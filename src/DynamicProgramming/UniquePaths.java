package DynamicProgramming;

/**
 * @program: Exercises
 * @description: 不同路径
 * @author: 宋丽
 * @create: 2020-11-05 19:41
 **/
public class UniquePaths {
    /**
     * 动态规划
     * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
