package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 数组中的最长山脉
 * @author: 宋丽
 * @create: 2020-10-25 14:22
 **/
public class LongestMountain {
    /**
     * 我的解法
     * max 为最长山脉的长度，初始值为0
     * i 为当前位置的下标
     * high 记录当前山脉的长度（因为左山脚没有计入，故 high+1 才是真正的山脉长度）
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        int len = A.length;
        if(len < 3){
            return 0;
        }
        int max = 0;
        int i = 1;
        int high = 0;
        while(i < len){
            //山脉上升阶段
            if (A[i] > A[i - 1]){
                while (i < len && A[i] > A[i - 1]) {
                    //System.out.println("上升" + A[i]);
                    i++;
                    high++;
                }
                //上升结束后如果紧接着下降
                if (i < len && A[i] < A[i - 1]){
                    while (i < len && A[i] < A[i - 1]){
                        //System.out.println("下降"+A[i]);
                        i++;
                        high++;
                    }
                    //下降结束，记录最高山脉长度
                    max = Math.max(max,high + 1);
                }
                //重置山脉长度
                high = 0;
                //如果山脉一开始没有处于上升阶段则继续向前扫描
            }else {
                i++;
            }
        }
        return max;
    }
}
