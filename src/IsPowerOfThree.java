/**
 * @program: Exercises
 * @description: 判断是否是3的幂
 * @author: 宋丽
 * @create: 2020-09-24 15:55
 **/
public class IsPowerOfThree {
    /**
     *我的方法，使用递归每次除3进行判断
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if(n == 0){
            return false;
        }
        if(n == 3 || n == 1){
            return true;
        }
        if(n % 3 == 0){
            return isPowerOfThree(n/3);
        }else{
            return false;
        }
    }

    /**
     * 基准转换
     * 将所给数字转换成三进制然后使用正则表达式进行比较
     * @param n
     * @return
     */
    public boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    /**
     * 整数限制
     * 利用int类型最大值为 2147483647的限制来解题
     * 用其中最大的 3^{19}除以n余数为0则满足要求
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree3(int n) {
        return n > 0 && 1162261467 % n == 0;
    }



}
