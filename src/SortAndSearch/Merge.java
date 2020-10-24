package SortAndSearch;

import java.util.*;

/**
 * @program: Exercises
 * @description: 合并区间
 * @author: 宋丽
 * @create: 2020-10-23 21:40
 **/
public class Merge {
    /**
     * 我的解法
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        //区间集排序
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });
        int len = intervals.length;
        if(len == 0){
            return intervals;
        }
        int start = intervals[0][0];
        int end = intervals[0][1];
        Deque<Integer> stake = new ArrayDeque<>();
        stake.addLast(start);
        stake.addLast(end);
        for(int i = 1 ; i < len ; i++){
            if(intervals[i][1] > end){
                if(intervals[i][0] > end){
                    start = intervals[i][0];
                    end = intervals[i][1];
                    stake.addLast(intervals[i][0]);
                    stake.addLast(intervals[i][1]);
                }else{
                    end = intervals[i][1];
                    stake.removeLast();
                    stake.addLast(intervals[i][1]);

                }
            }
        }
        int len2 = stake.size() / 2;
        int[][] res = new int[len2][2];
        for(int i = 0 ; i < len2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                res[i][j] = stake.removeFirst();
            }
        }
        return res;
    }
}
