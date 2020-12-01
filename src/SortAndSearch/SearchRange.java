package SortAndSearch;

/**
 * @program: Exercises
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: 宋丽
 * @create: 2020-10-23 21:12
 **/
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {

        //折半查找到目标值的下标
        int mid = midSearch(nums,target);

        if (mid == -1){
           return new int[]{-1, -1};
        }
        //分别向左向右扩展找到start和end的值
        int start = mid;
        int end = mid;
        while (nums[start] == target){
            start--;
            if (start < 0){
                break;
            }
        }
        while (nums[end] == target){
            end++;
            if (end >= nums.length){
                break;
            }
        }
        return new int[]{start + 1,end - 1};

    }

    private int midSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] > target){
                right = mid - 1;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
            if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }

    /**
     * 双指针
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int len = nums.length;
        if(len < 1){
            return new int[]{-1 , -1};
        }
        int left = 0;
        int right = len - 1;
        while(nums[left] != target || nums[right] != target){
            if(nums[left] != target){
                left++;
            }
            if(nums[right] != target){
                right--;
            }
            if(left > right){
                return new int[]{-1 , -1};
            }
        }
        return new int[]{left,right};
    }
}
