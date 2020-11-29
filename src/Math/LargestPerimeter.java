package Math;

import java.util.Arrays;

/**
 * @program: Exercises
 * @description: 三角形的最大周长
 * @author: 宋丽
 * @create: 2020-11-29 23:34
 **/
public class LargestPerimeter {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 2; i--) {
            int a = A[i];
            int b = A[i - 1];
            int c = A[i - 2];
            if(a < b + c){
                return a + b + c;
            }
        }
        return 0;
    }
}
