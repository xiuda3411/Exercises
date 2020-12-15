package Math;

/**
 * @program: Exercises
 * @description: 单调递增的数字
 * @author: 宋丽
 * @create: 2020-12-15 19:44
 **/
public class MonotoneIncreasingDigits {
    /**
     * 递归
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits(int N) {
        for (int i = N, j = 9, k = 1; i > 0; i /= 10, k *= 10) {
            if (j < (j = i % 10)) {
                return monotoneIncreasingDigits(i * k - 1);
            }
        }
        return N;
    }

    /**
     * 找出递增的断层，断层位-1，后面全为9
     * 比如2333331，index = 1的位置-1，后面其余位为9
     * @param N
     * @return
     */
    public int monotoneIncreasingDigits2(int N) {
         char[] c = (N + "").toCharArray();
         int max = -1;
         int index = -1;
         for(int i = 0 ; i < c.length - 1 ; i++){
             if(max < c[i]){
                 max = c[i];
                 index = i;
             }
             if(c[i + 1] < c[i]){
                 c[index]--;
                 for(int j = index + 1 ; j < c.length ; j++){
                     c[j] = '9';
                 }
                 break;
             }
         }
         return Integer.parseInt(new String(c));
    }
}
