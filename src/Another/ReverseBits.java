package Another;

/**
 * @program: Exercises
 * @description: 颠倒二进制位
 * @author: 宋丽
 * @create: 2020-09-25 20:57
 **/
public class ReverseBits {
    /**
     * 我的方法
     * 检测n的最后一位数，来判断是否对r进行加1，n右移r左移
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int r = 0;
        for (int i = 0; i < 32 ; i++){
            r <<= 1;
            if ((n & 1) == 1){
                r++;
            }
            n >>= 1;
        }
        return r;
    }
}
