package ArraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: Exercises
 * @description: 四数之和
 * @author: 宋丽
 * @create: 2020-10-05 20:48
 **/
public class FourSum {
    /**
     * 我的解法
     * 双重循环加上双指针
     * 每重循环和双指针部分都要进行去重
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if (len > 5){
            for (int i = 0; i < len-3; i++){
                System.out.println(1);
                if ( i > 0 && nums[i] == nums[i-1]){
                    continue;
                }
                for (int j = i+1 ; j < len-2; j++){
                    if (j > i+1 && nums[j] == nums[j-1]){
                        continue;
                    }
                    int m = j+1;
                    int n = len-1;
                    //双指针
                    while (n > m){
                        //去重
                        System.out.println(nums[i]+""+nums[j]+""+nums[m]+""+nums[n]);
                        while (m > j+1 && nums[m] == nums[m-1]){
                            m++;
                        }
                        while (n < len-1 && nums[n] == nums[n+1]){
                            n--;
                        }
                        if (n <= m){
                            break;
                        }
                        if (target == nums[i]+nums[j]+nums[m]+nums[n]){
                            System.out.println(i+""+j+""+m+""+n);
                            lists.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[m],nums[n])));
                            m++;
                            n--;
                        }else if (target > nums[i]+nums[j]+nums[m]+nums[n]){
                            m++;
                        }else {
                            n--;
                        }
                    }
                }
            }
        }
        return lists;
    }
}
