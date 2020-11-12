package SortAndSearch;

/**
 * @program: Exercises
 * @description: 按奇偶排序数组2
 * @author: 宋丽
 * @create: 2020-11-12 22:23
 **/
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length - 1; i = i + 2) {
            if ((A[i] & 1) != 0) {
                while ((A[j] & 1) != 0) {
                    j = j + 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }
}
