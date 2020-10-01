package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 递增的三元子序列
 * @author: 宋丽
 * @create: 2020-10-01 21:54
 **/
public class IncreasingTriplet {
    /**
     * 贪心算法
     * 设定一个最小值和第二小的值
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if(len < 3){
            return false;
        }
        //最小值
        int firstMin = Integer.MAX_VALUE;
        //第二最小值
        int secondMin = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= firstMin) {
                firstMin = num;
            } else if (num <= secondMin) {
                secondMin = num;
            } else {
                return true;
            }
        }
        return false;
    }
    /**
     * 此题也可用dp做
     * 初始化一个dp[]
     * 如果nums[i]<nums[i-1],dp[i] = dp[i-1]
     * 如果nums[i]>nums[i-1] && dp[i-1] == false,dp[i] = true;
     * 如果nums[i]>nums[i-1] && dp[i-1] == true,return true;
     */
}
