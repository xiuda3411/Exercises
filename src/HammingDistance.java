/**
 * @program: Exercises
 * @description: 汉明距离
 * @author: 宋丽
 * @create: 2020-09-25 19:23
 **/
public class HammingDistance {
    /**
     * 我的方法
     * 将x和y进行逻辑或运算的值减去逻辑与的值，所得值的汉明重量即x与y之间的汉明距离
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        //int a = (x | y)-(x & y);
        int a = x^y;
        int count = 0;
        while (a != 0){
            count++;
            a &= a-1;
        }
        return count;
    }

    /**
     * 内置位计数功能
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
