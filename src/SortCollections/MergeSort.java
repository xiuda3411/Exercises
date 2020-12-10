package SortCollections;

import java.util.Arrays;

/**
 * @program: Exercises
 * @description: 归并排序
 * @author: 宋丽
 * @create: 2020-12-10 21:38
 **/
public class MergeSort {
    /**
     * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array){
        int len = array.length;
        int mid =  len / 2;
        int[] left = Arrays.copyOfRange(array,0,mid);
        int[] right = Arrays.copyOfRange(array,mid,0);
        return merge(MergeSort(left),MergeSort(right));
    }

    /**
     * 将两段排序好的数组合并成一个数组
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for(int index = 0 , i = 0 , j = 0 ; index < res.length ; index++){
            if(i >= left.length){
                res[index] = right[j++];
            }else if(j >= left.length){
                res[index] = left[i++];
            }else if(left[i] > right[j]){
                res[index] = right[j++];
            }else{
                res[index] = left[i++];
            }
        }
        return res;
    }
}
