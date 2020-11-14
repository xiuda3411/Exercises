package SortAndSearch;

/**
 * @program: Exercises
 * @description: 数组的相对排序
 * @author: 宋丽
 * @create: 2020-11-14 19:57
 **/
public class RelativeSortArray {
    /**
     * 计数排序
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for(int i = 0 ; i < arr1.length ; i++){
            count[arr1[i]]++;
        }

        int index = 0;
        for(int j = 0 ; j < arr2.length ; j++){
            while(count[arr2[j]] != 0){
                count[arr2[j]]--;
                arr1[index++] = arr2[j];
            }
        }

        for(int k = 0 ; k < count.length ; k++){
            while(count[k] != 0){
                count[k]--;
                arr1[index++] = k;
            }
        }

        return arr1;
    }
}
