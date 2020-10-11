package DynamicProgramming;

/**
 * @program: Exercises
 * @description: 分割等和子集
 * @author: 宋丽
 * @create: 2020-10-11 12:03
 **/
public class CanPartition {
    /**a
     * 动态规划
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        int len = nums.length;

        if (len == 0){
            return true;
        }
        if (len < 2){
            return false;
        }

        int sum = 0;
        int Max = 0;

        for (int i:nums) {
            sum += i;
            Max = Math.max(Max,i);
        }

        if (sum % 2 != 0){
            return false;
        }

        int target = sum / 2 ;

        if (Max > target){
            return false;
        }

        boolean[][] dp = new boolean[len][target+1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }

        dp[0][nums[0]] = true;
        for (int i = 1; i < len; i++) {
            int num = nums[i];
            for (int j = 1; j < target + 1; j++) {
                if (j >= num){
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j-num];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len-1][target];
    }
}
