package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 翻转矩阵后的得分
 * @author: 宋丽
 * @create: 2020-12-07 16:06
 **/
public class MatrixScore {
    /**
     * 我的方法，模拟翻转过程
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int row = A.length;
        int cln = A[0].length;
        int res = 0;
        for(int k = 0; k < cln; k++) {
            int zero = 0;
            int one = 0;
            int temp = 0;
            for (int i = 0; i < row; i++) {
                if (A[i][0] == 0) {
                    for (int j = 0; j < cln; j++) {
                        A[i][j] = A[i][j] == 0 ? 1 : 0;
                    }
                }
                if (A[i][k] == 0) {
                    zero++;
                } else {
                    one++;
                }
                temp += A[i][k] << (cln - 1 - k);
            }
            if (zero > one) {
                temp = 0;
                for (int t = 0; t < row; t++) {
                    A[t][k] = A[t][k] == 0 ? 1 : 0;
                    temp += A[t][k] << (cln - 1 - k);
                }
            }
            res += temp;
        }
        return res;
    }

    /**
     * 简化后
     * @param A
     * @return
     */
    public int matrixScore2(int[][] A) {
        int row = A.length;
        int cln = A[0].length;
        int res = 0;
        for (int i = 0; i < cln; i++) {
            int temp = 0;
            int weight = cln - 1 - i;
            for (int j = 0; j < row; j++) {
                if (i == 0) {
                    temp += 1 << weight;
                } else {
                    temp += A[j][0] == 0 ? (1 - A[j][i]) << weight : A[j][i] << weight;
                }
            }
            res += Math.max(temp, row * (1 << weight) - temp);
        }
        return res;
    }

    /**
     * 官方贪心算法，和2思想一致
     * @param A
     * @return
     */
    public int matrixScore3(int[][] A) {
        int m = A.length, n = A[0].length;
        int ret = m * (1 << (n - 1));

        for (int j = 1; j < n; j++) {
            int nOnes = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    nOnes += (1 - A[i][j]); // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                }
            }
            int k = Math.max(nOnes, m - nOnes);
            ret += k * (1 << (n - j - 1));
        }
        return ret;
    }
}
