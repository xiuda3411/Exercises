package SortCollections;

/**
 * @program: Exercises
 * @description: 插入排序 ①直接插入排序；②希尔排序；
 * @author: 宋丽
 * @create: 2020-12-10 20:42
 **/
public class InsertSort {
    /**
     * 直接插入排序
     * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array){
        int len = array.length;
        int curr;
        for(int i = 0 ; i < len - 1 ; i++){
            curr = array[i + 1];
            int pre = i;
            while(pre >= 0 && array[pre] > curr){
                array[pre + 1] = array[pre];
                pre--;
            }
            array[pre + 1] = curr;
        }
        return array;
    }

    /**
     * 希尔排序
     * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array){
        int len = array.length;
        int gap = len / 2;
        int temp;
        while(gap > 0){
            for(int i = gap ; i < len ; i++){
                temp = array[i];
                int pre = i - gap;
                while(pre >= 0 && array[pre] > temp){
                    array[pre + gap] = array[pre];
                    pre -= gap;
                }
                array[pre + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
