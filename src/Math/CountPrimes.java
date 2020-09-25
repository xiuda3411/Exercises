package Math;

/**
 * @program: Exercises
 * @description: 计算质数
 * @author: 宋丽
 * @create: 2020-09-24 13:54
 **/
public class CountPrimes {
    /**
     * 我的方法，暴力求解法优化后勉强达到执行用时的要求
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int sum = 1;
        if(n < 3){
            return 0;
        }
        for(int i = 3; i < n; i++){
            if(i % 2 == 0){
                continue;
            }
            boolean flag = false;
            for(int j = 3;j*j <= i; j+=2){
                if(i%j == 0){
                    flag = true;
                    break;
                }
            }
            if(!flag ){
                sum++;
            }
        }
        return sum;
    }

    /**
     * 厄拉多塞筛法
     * 寻找质数并在寻找的同时排除它的倍数
     * @param n
     * @return
     */
    public int countprimes2(int n){
        int count = 0;
        boolean[] primes = new boolean[n];
        for(int i = 2; i < n; i++){
            if(!primes[i]){
                count++;
                for(int j = i + i ; j < n; j += i){
                    primes[j] = true;
                }
            }
        }
        return count;
    }
}
