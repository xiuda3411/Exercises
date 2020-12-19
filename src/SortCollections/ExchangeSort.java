package SortCollections;

/**
 * @program: Exercises
 * @description: 交换排序：①冒泡排序；②快速排序
 * @author: 宋丽
 * @create: 2020-12-09 18:43
 **/


public class ExchangeSort {
    /**
     * 冒泡排序
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

    /**
     * 快速排序
     * 最佳情况：T(n) = O(nlogn) 每次取的基准都为中位数    最差情况：T(n) = O(n2) 每次取的基准为最大值或最小值  平均情况：T(n) = O(nlogn)　
     * @param array
     * @param begin
     * @param end
     * @return
     */
    public static int[] quickSort(int[] array, int begin, int end){
        if(begin < end){
            int temp = array[begin];
            int i = begin;
            int j = end;
            while(i < j){
                while(i < j && array[j] > temp){
                    j--;
                }
                array[i] = array[j];
                while(i < j && array[i] <= temp){
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = temp;
            quickSort(array, begin, i - 1);
            quickSort(array, i + 1, end);
        }
        return array;
    }
//    public static void main(String[] args){
//        int[] num = {23,45,17,11,13,89,72,26,3,17,11,13};
//        int n = 12;
//        num = quickSort(num,0,n-1);
//        for(int i : num){
//            System.out.print(i + " ");
//        }
//    }
    
//    public static int[] quickSort(int[] array, int start, int end){
//        if(array.length < 1 || start < 0 || end >= array.length || start > end){
//            return null;
//        }
//        int smallIndex = partition(array, start, end);
//
//    }
//
//    /**
//     * 快速排序——分区操作partition
//     * @param array
//     * @param start
//     * @param end
//     * @return
//     */
//    private static int partition(int[] array, int start, int end) {
//        //基准值，随机获取
//        int pivot = (int)(start + Math.random() * (end - start + 1));
//        int smallIndex = start - 1;
//        swap(array, pivot, end);
//        for(int i = start; i <= end; i++){
//            if(array[i] <= array[end]){
//                smallIndex++;
//                if(i > smallIndex){
//                    swap(array, i, smallIndex);
//                }
//            }
//        }
//        return smallIndex;
//    }
//
//    private static void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

}
