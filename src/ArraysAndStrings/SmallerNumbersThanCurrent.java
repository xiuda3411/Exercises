package ArraysAndStrings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: Exercises
 * @description: 有多少小于当前数字的数字
 * @author: 宋丽
 * @create: 2020-10-26 12:39
 **/
public class SmallerNumbersThanCurrent {
    /**
     * 快速排序
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[][] log = new int[len][2];
        for (int i = 0; i < len; i++) {
            log[i][0] = nums[i];
            log[i][1] = i;
        }
        Arrays.sort(log, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0] - o2[0];
            }
        });

        int[] res = new int[len];
        int pre = -1;

        for (int i = 0; i < len; i++) {
            if (pre == -1 || log[i][0] != log[i - 1][0]){
                pre = i;
            }
            res[log[i][1]] = pre;
        }
        return res;
    }
}
