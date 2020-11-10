package ArraysAndStrings;

import java.util.Arrays;

/**
 * @program: Exercises
 * @description: 下一个排列
 * @author: 宋丽
 * @create: 2020-11-10 20:38
 **/
public class NextPermutation {
    /**
     * 我的解法，两次扫描
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int end = len - 1;
        for(int i = end - 1 ; i >= 0 ; i--){
            if(nums[i] < nums[i + 1]){
                int miner = Integer.MAX_VALUE;
                int tep = -1;
                for(int j = i + 1 ; j <= end ; j++){
                    if(nums[j] > nums[i]){
                        miner = Math.min(miner,nums[j]);
                        tep = j;
                    }
                }
                nums[tep] = nums[i];
                nums[i] = miner;

                int[] rest = Arrays.copyOfRange(nums,i + 1, len);
                Arrays.sort(rest);

                for(int k = i + 1; k < len ; k++){
                    nums[k] = rest[k - i - 1];
                }
                return;
            }
        }
        Arrays.sort(nums);
    }

    /**
     * 两次扫描，交换+翻转
     * @param nums
     */
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
