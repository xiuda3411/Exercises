package Another;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 查找缺失值
 * @author: 宋丽
 * @create: 2020-09-27 21:28
 **/
public class MissingNumber {
    /**
     * 我的解法
     * 利用包含 0, 1, 2, ..., n 中 n 个数的序列的和
     * 减去所给数字的和即为缺失值
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int size = nums.length;
        int should = size*(size+1)/2;
        int now = 0;
        for (int i:nums
             ) {
            now += i;
        }
        return should-now;
    }

    /**
     * 位运算
     * 异或运算满足结合律，利用下标和数组中数字的特性
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }


    /**
     * 利用哈希表的特性
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

}
