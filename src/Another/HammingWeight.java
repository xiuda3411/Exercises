package Another;

/**
 * @program: Exercises
 * @description: 求汉明重量
 * @author: 宋丽
 * @create: 2020-09-25 10:33
 **/
public class HammingWeight {
    /**
     * 我的方法
     * 把输入数转换为二进制字符串然后转换成字符数组进行计数
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        char[] c = s.toCharArray();
        for (char a:c
             ) {
            if (a == '1'){
                count++;
            }
        }
        return count;
    }

    /**
     * 循环和位移动的方法
     * 任何数和1进行与运算获得这个数字的最低位
     * 然后将数字进行左移或右移处理进行循环
     *
     * >>带符号右移，符号位不变，左边补上符号位，低位移出
     *
     * >>>无符号右移，0补最高位，低位移出
     *
     * <<左移符号，丢弃最高位，0补最低位
     * @param n
     * @return
     * 时间复杂度：O(1)O(1) 。运行时间依赖于数字 nn 的位数。由于这题中 nn 是一个 32 位数，所以运行时间是 O(1)O(1) 的。
     *
     * 空间复杂度：O(1)O(1)。没有使用额外空间。
     *
     */
    public int hammingWeight2(int n) {
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32;i++){
            if ((n & mask) == 1){
                count++;
            }
            n >>>= 1;
        }
        return count;
    }

    /**
     * 位操作的小技巧
     * n与n-1进行逻辑与运算，会将n最后一个1变成0，循环到最后n变成0
     * @param n
     * @return
     */
    public int hammingWeight3(int n) {
        int count = 0;
        while (n != 0){
            count++;
            n &= n-1;
        }
        return count;
    }


}
