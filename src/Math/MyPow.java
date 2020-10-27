package Math;

/**
 * @program: Exercises
 * @description: 实现pow(x, n), 即计算x的n次幂
 * @author: 宋丽
 * @create: 2020-10-27 21:57
 **/
public class MyPow {
    /**
     * 注意特殊值Integer.MIN_VALUE，乘上-1后变为0
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double remain = 1;
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            if (n == Integer.MIN_VALUE) {
                n++;
                remain *= x;
            }
            n = n * (-1);

        }

        while (n != 0) {
            //奇数次幂
            if (n % 2 == 1) {
                remain *= x;
            }
            n = n / 2;
            x *= x;
        }
        return remain;
    }
}
