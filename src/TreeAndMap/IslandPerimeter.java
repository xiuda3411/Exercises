package TreeAndMap;

/**
 * @program: Exercises
 * @description: 岛屿周长
 * @author: 宋丽
 * @create: 2020-10-30 18:11
 **/
public class IslandPerimeter {
    /**
     * 暴力法
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int cul = grid[0].length;
        int sum = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < cul ; j++){
                if(grid[i][j] == 1){
                    if(i + 1 == row || grid[i + 1][j] == 0){
                        sum++;
                    }
                    if(i - 1 == -1 || grid[i - 1][j] == 0){
                        sum++;
                    }
                    if(j - 1 == -1 || grid[i][j - 1] == 0){
                        sum++;
                    }
                    if(j + 1 == cul || grid[i][j + 1] == 0){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
