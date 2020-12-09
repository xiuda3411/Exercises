package SortCollections;

/**
 * @program: Exercises
 * @description: 选择排序：①简单选择排序；②堆排序；
 * @author: 宋丽
 * @create: 2020-12-09 19:06
 **/
public class SelectSort {
    public static int[] selectionSort(int[] array){
        int len = array.length;
        for(int i = 0 ; i < len ; i++){
            int index = i;
            for(int j = i ; j < len ; j++){
                if(array[j] < array[i]){
                    i = j;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
        return array;
    }
}
