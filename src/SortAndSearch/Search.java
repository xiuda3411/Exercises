package SortAndSearch;

/**
 * @program: Exercises
 * @description: 搜索旋转排序数组
 * @author: 宋丽
 * @create: 2020-10-26 11:47
 **/
public class Search {
    /**
     * 二分查找，注意判断条件的细节
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > nums[len - 1]){
                if (nums[mid] > target && target > nums[len - 1]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }

            }else {
                if (nums[mid] < target && target <= nums[len - 1]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
