package SortAndSearch;

/**
 * @program: Exercises
 * @description: 搜索二维矩阵2
 * @author: 宋丽
 * @create: 2020-10-26 17:02
 **/
public class SearchMatrix {
    /**
     * 根据矩阵特性从左下角或右上角开始寻找目标值
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix.length - 1;
        while ( y >= 0 && x < matrix[0].length){
            if (matrix[y][x] == target){
                return true;
            }else if (matrix[y][x] > target){
                y--;
            }else {
                x++;
            }
        }
        return false;
    }
}
