package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 颜色分类
 * @author: 宋丽
 * @create: 2020-10-07 18:59
 **/
public class SortColors {
    /**
     * 我的解法
     * 两次扫描
     * @param nums
     */
    public void sortColors(int[] nums) {
        int len = nums.length;
        int red = 0;
        int white = 0;
        int blue = 0;
        for(int i = 0 ; i < len ; i++){
            switch (nums[i]){
                case 0: red++; break;
                case 1: white++; break;
                case 2: blue++; break;
                default:
                    System.out.println("查无此颜色");
                    break;
            }
        }
        for (int i = 0 ; i < len ; i++){
            if (red != 0){
                nums[i] = 0;
            }else if (white != 0){
                nums[i] = 1;
            }else if (blue != 0){
                nums[i] = 2;
            }
        }
    }

    /**
     * 单指针循环两次
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    /**
     * 双指针
     * 两个指针起点相同，都在最左边
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1){
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                p0++;
                p1++;
            }else if (nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
        }
    }

    /**
     * 双指针
     * 起点不同，一左一右
     * @param nums
     */
    public void sortColors4(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; ++i) {
            while (i <= p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                --p2;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }
}
