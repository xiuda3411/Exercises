package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Exercises
 * @description: 三数之和
 * @author: 宋丽
 * @create: 2020-09-27 21:49
 **/
public class ThreeSum {
    /**
     * 我的方法
     * 三次循环用时太长，并且如果用contains判断会超出时间限制
     * 优化为二次循环，在第二次循环中找出能与第一个数组合的两个值的下标
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < size-2; i++){

            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int k = size - 1;
            int t = -nums[i];

            for(int j = i+1; j < size-1; j++){

                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                while (j < k && nums[j] + nums[k] > t){
                    --k;
                }

                if (j == k){
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0 ) {
                    List<Integer> inside = new ArrayList<>();
                    inside.add(nums[i]);
                    inside.add(nums[j]);
                    inside.add(nums[k]);
                    out.add(inside);

                }
            }
        }
        return out;
    }

    /**
     * 简练清晰版
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {// 总时间复杂度：O(n^2)
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return ans;
        }

        Arrays.sort(nums); // O(nlogn)

        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) {
                break; // 第一个数大于 0，后面的数都比它大，肯定不成立了
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去掉重复情况
            }
            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return ans;
    }
}
