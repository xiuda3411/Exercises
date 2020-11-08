package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 数组中重复的数字
 * @author: 宋丽
 * @create: 2020-11-08 20:12
 * （先问时间/空间需求）
 * ①时间优先，使用字典
 * ②空间要求，使用指针＋原地
 * ③空间O(1)，并且不能修改原数组，使用二分法
 **/
public class FindRepeatNumber {
    /**
     * 字典，哈希表
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!set.add(nums[i])){
                return nums[i];
            }
            //优化后使用add的返回值进行判断，节省时间
//            if(set.contains(nums[i])){
//                return nums[i];
//            }else{
//                set.add(nums[i]);
//            }
        }
        return -1;
        //新开一个数组进行记录
//        int[] arr = new int[nums.length];
//        for(int i = 0; i < nums.length; i++){
//            arr[nums[i]]++;
//            if(arr[nums[i]] > 1) return nums[i];
//        }
//        return -1;
    }

    /**
     * 指针+原地
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }
}
