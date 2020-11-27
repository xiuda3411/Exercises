package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: Exercises
 * @description: 四数相加2
 * @author: 宋丽
 * @create: 2020-11-27 10:59
 **/
public class FourSumCount {
    /**
     * 分组＋哈希表
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int i : A) {
            for (int j : B) {
                map.put(i + j, map.getOrDefault(i + j,0) + 1);
            }
        }
        for(int i : C){
            for(int j : D){
                res += map.getOrDefault(-i-j,0);
            }
        }
        return res;
    }
}
