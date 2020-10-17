package Backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: N皇后 II
 * @author: 宋丽
 * @create: 2020-10-17 13:26
 **/
public class TotalNQueens {
    public int totalNQueens(int n) {
        //无法放置queen的列set
        Set<Integer> clumns = new HashSet<>();
        //无法放置queen的斜线set1
        Set<Integer> diagonals1 = new HashSet<>();
        //无法放置queen的斜线set2
        Set<Integer> diagonals2 = new HashSet<>();
        return setQueen(n,0,clumns,diagonals1,diagonals2);
    }

    /**
     *
     * @param n 皇后数量
     * @param row 行数
     * @param clumns 列set
     * @param diagonals1 正斜对角线集
     * @param diagonals2 反斜对角线集
     * @return
     */
    private int setQueen(int n, int row, Set<Integer> clumns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n){
            return 1;
        }else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (clumns.contains(i)){
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)){
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)){
                    continue;
                }
                clumns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += setQueen(n, row + 1, clumns, diagonals1, diagonals2);
                clumns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
}
