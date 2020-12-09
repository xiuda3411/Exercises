package SortCollections;

/**
 * @program: Exercises
 * @description: 交换排序：①冒泡排序；②快速排序
 * @author: 宋丽
 * @create: 2020-12-09 18:43
 **/


public class ExchangeSort {
    /**
     * 最佳情况：T(n) = O(n)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(n2)
     */
    public static int[] bubbleSort(int[] array){
        int len = array.length;
        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len - 1 - i ; j++){
                //如果前一个数大于后一个数，则交换
                //最佳情况就是array已经排好序，时间复杂度为O(n)
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }


}
