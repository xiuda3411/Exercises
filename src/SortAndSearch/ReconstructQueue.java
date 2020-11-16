package SortAndSearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 根据身高重建队列
 * @author: 宋丽
 * @create: 2020-11-16 16:38
 **/
public class ReconstructQueue {
    /**
     * 先对输入数组排序，h升序，k降序 从头循环遍历
     * 当前这个人就是剩下未安排的人中最矮的人，
     * 他的k值就代表他在剩余空位的索引值 如果有多个人高度相同，
     * 要按照k值从大到小领取索引值 示例：
     * [ 0, 1, 2, 3, 4, 5 ] [ 4, 4 ] 4
     * [ 0, 1, 2, 3, 5 ]    [ 5, 2 ] 2
     * [ 0, 1, 3, 5 ]       [ 5, 0 ] 0
     * [ 1, 3, 5 ]          [ 6, 1 ] 3
     * [ 1, 5 ]             [ 7, 1 ] 5
     * [ 1 ]                [ 7, 0 ] 1
     * [ [ 5, 0 ], [ 7, 0 ], [ 5, 2 ], [ 6, 1 ], [ 4, 4 ], [ 7, 1 ] ]
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        LinkedList<Integer> list = new LinkedList<>();
        int len = people.length;
        int[][] res = new int[len][2];
        for (int i = 0; i < len; i++) {
            list.add(i);
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        for (int i = 0; i < len; i++) {
            int index = people[i][1];
            res[list.get(index)] = people[i];
            list.remove(index);
        }
        return res;
    }
}
