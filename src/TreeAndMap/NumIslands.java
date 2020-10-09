package TreeAndMap;

import java.util.LinkedList;

/**
 * @program: Exercises
 * @description: 岛屿数量
 * @author: 宋丽
 * @create: 2020-10-09 17:15
 **/
public class NumIslands {

    /**
     * 深度优先搜索
     * 检查到一块岛屿时将其所有土地变成水，岛屿计数加一，继续寻找下一块岛屿
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0){
            return 0;
        }

        int rowLen = grid.length;
        int columnsLen = grid[0].length;
        int count = 0;

        for (int i = 0 ; i < rowLen ; i++){
            for (int j = 0 ; j < columnsLen ; j++){
                if (grid[i][j] == '1'){
                    count++;
                    help(grid,i,j);
                }
            }
        }
        return count;
    }

    /**
     * 将一片区域的0都变成1
     * @param grid 地图
     * @param row 某点的行
     * @param columns 某点的列
     */
    private void help(char[][] grid,int row,int columns){

        int rowLen = grid.length;
        int columnsLen = grid[0].length;

        if (row < 0 || row >=rowLen || columns >= columnsLen || columns < 0 || grid[row][columns] == '0'){
            return;
        }

        grid[row][columns] = '0';
        help(grid,row-1,columns);
        help(grid,row,columns-1);
        help(grid,row+1,columns);
        help(grid,row,columns+1);
    }

    /**
     * 广度优先算法
     * @param grid
     * @return
     */
    public int numIslands2(char[][] grid) {

        if (grid == null || grid.length == 0){
            return 0;
        }

        int rowLen = grid.length;
        int columnsLen = grid[0].length;
        int count = 0;

        for(int i = 0 ; i < rowLen ; i++){
            for (int j = 0; j < columnsLen; j++) {
                if (grid[i][j] == '1'){
                    count++;
                    LinkedList<Integer> stack = new LinkedList<>();
                    stack.add(i*columnsLen+j);
                    while (!stack.isEmpty()){
                        int id = stack.remove();
                        int r = id/columnsLen;
                        int c = id%columnsLen;
                        if (r-1 >= 0 && grid[r-1][c] == '1'){
                            stack.add((r-1)*columnsLen+c);
                            grid[r-1][c] = '0';
                        }
                        if (r+1 < rowLen && grid[r+1][c] == '1'){
                            stack.add((r+1)*columnsLen+c);
                            grid[r+1][c] = '0';
                        }
                        if (c-1 >= 0 && grid[r][c-1] == '1'){
                            stack.add(r*columnsLen+(c-1));
                            grid[r][c-1] = '0';
                        }
                        if (c+1 < columnsLen && grid[r][c+1] == '1'){
                            stack.add(r*columnsLen+(c+1));
                            grid[r][c+1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 并查集算法
     */
}
