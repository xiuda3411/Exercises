package SortAndSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: Exercises
 * @description: 距离顺序排序矩阵单元格
 * @author: 宋丽
 * @create: 2020-11-17 18:36
 **/
public class AllCellsDistOrder {
    /**
     * 重写比较器compare
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int k = 0;
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                res[k][0] = i;
                res[k][1] = j;
                k++;
            }
        }
        Arrays.sort(res,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                int d1 = Math.abs(r0 - o1[0]) + Math.abs(c0 - o1[1]);
                int d2 = Math.abs(r0 - o2[0]) + Math.abs(c0 - o2[1]);
                return d1 - d2;
            }
        });
        return res;
    }

    /**
     * 桶排序
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        List<List<int[]>> bucket = new ArrayList<List<int[]>>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int d = dist(i, j, r0, c0);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[R * C][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    /**
     * 几何法，因为题目要求是曼哈顿距离
     */
    int[] dr = {1, 1, -1, -1};
    int[] dc = {1, -1, -1, 1};

    public int[][] allCellsDistOrder3(int R, int C, int r0, int c0) {
        int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
        int[][] ret = new int[R * C][];
        int row = r0, col = c0;
        int index = 0;
        ret[index++] = new int[]{row, col};
        for (int dist = 1; dist <= maxDist; dist++) {
            row--;
            for (int i = 0; i < 4; i++) {
                while ((i % 2 == 0 && row != r0) || (i % 2 != 0 && col != c0)) {
                    if (row >= 0 && row < R && col >= 0 && col < C) {
                        ret[index++] = new int[]{row, col};
                    }
                    row += dr[i];
                    col += dc[i];
                }
            }
        }
        return ret;
    }
}
