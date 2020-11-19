package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 移除元素
 * @author: 宋丽
 * @create: 2020-10-27 20:05
 **/
public class RemoveElement {
    /**
     * 双指针
     * 一头一尾
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int last = nums.length - 1;
        int start = 0;
        while (start <= last){
            if (nums[start] == val){
                int temp = nums[start];
                nums[start] = nums[last];
                nums[last] = temp;
                last--;
            }else {
                start++;
            }
        }
        return start;
    }

    /**
     * 双指针
     * 齐头并进
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
