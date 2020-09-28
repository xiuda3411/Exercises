package ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 矩阵置零
 * @author: 宋丽
 * @create: 2020-09-28 12:21
 **/
public class SetZeroes {
    /**
     * 我的解法
     * 用哈希表保存矩阵中0的列号和行号
     * 再次循环改变矩阵的值
     * 时间复杂度：O(M \times N)O(M×N)，其中 MM 和 NN 分别对应行数和列数
     * 空间复杂度：O(M+N)O(M+N)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        //行
        Set<Integer> row = new HashSet<>(matrix.length);
        //列
        Set<Integer> line = new HashSet<>(matrix[0].length);
        for (int i = 0; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[0].length;j++){
                if (matrix[i][j] == 0){
                    row.add(i);
                    line.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length;i++){
            for(int j = 0 ; j < matrix[0].length;j++){
                if (row.contains(i) || line.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 原地算法
     * 将对应0的第一行第一列赋值为0
     * 再次循环将对应行列数字赋值为0
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }
        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
