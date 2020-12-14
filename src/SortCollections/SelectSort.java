package SortCollections;

/**
 * @program: Exercises
 * @description: 选择排序：①简单选择排序；②堆排序；
 * @author: 宋丽
 * @create: 2020-12-09 19:06
 **/
public class SelectSort {
    /**
     * 简单选择排序
     * @param array
     * @return
     */
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

    public static int[] heapSort(int[] array){
        //1.构建大顶堆
        for(int i = array.length/2 - 1; i >=0; i--){
            adjustHeap(array,i,array.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = array.length-1; j > 0;j--){
            //将堆顶元素与末尾元素进行交换
            swap(array,0,j);
            //重新对堆进行调整
            adjustHeap(array,0,j);
        }
        return array;
    }

    private static void adjustHeap(int[] array, int i, int length) {
        //取出当前元素array[i]
        int temp = array[i];
        for(int k = i*2+1 ; k < length ; k = k*2+1){
            //如果左结点<右节点，k指向右结点
            if(k + 1 < length && array[k] < array[k + 1]){
                k++;
            }
            if(array[k] > temp){
                array[i] = array[k];
                i = k;
            }else{
                break;
            }
        }
        array[i] = temp;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
