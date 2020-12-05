package ArraysAndStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @program: Exercises
 * @description: 任务调度器
 * @author: 宋丽
 * @create: 2020-12-05 14:04
 **/
public class LeastInterval {
    /**
     * 数学方法
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int maxCount = 0;
        int mc = 0;
        int len = tasks.length;
        int[] count = new int[26];
        for(char c : tasks){
            count[c - 'A']++;
            maxCount = Math.max(count[c - 'A'],maxCount);
        }
        for(int i : count){
            if(i == maxCount){
                mc++;
            }
        }
        int res = (maxCount - 1) * (n + 1) + mc;
        return res > len ? res : len;
    }
}
