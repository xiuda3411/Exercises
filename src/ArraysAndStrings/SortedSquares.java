package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 有序数组的平方
 * @author: 宋丽
 * @create: 2020-10-16 12:55
 **/
public class SortedSquares {
    /**
     * 双指针法
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }
}
