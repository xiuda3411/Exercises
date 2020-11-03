package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 有效的山脉数组
 * @author: 宋丽
 * @create: 2020-11-03 13:28
 **/
public class ValidMountainArray {
    /**
     * 双指针
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;

    }
}
