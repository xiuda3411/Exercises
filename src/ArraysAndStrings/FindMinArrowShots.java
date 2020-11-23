package ArraysAndStrings;

import java.util.Arrays;

/**
 * @program: Exercises
 * @description: 用最少数量的箭引爆气球
 * @author: 宋丽
 * @create: 2020-11-23 16:37
 **/

public class FindMinArrowShots {
    /**
     * 贪心算法
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[1] < p2[1] ? -1 : 1);
        // for(int i = 0 ; i < points.length ; i++){
        //     for(int j = 0 ; j < 2 ; j++){
        //         System.out.print(points[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int res = 1;
        int pre = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > pre) {
                res++;
                pre = points[i][1];
            }
        }
        return res;
    }
}
