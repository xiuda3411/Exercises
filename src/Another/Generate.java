package Another;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 杨辉三角
 * @author: 宋丽
 * @create: 2020-09-26 20:31
 **/
public class Generate {

    /**
     * 我的解法
     * 循环，从上到下，从左到右
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>(numRows);

        for(int i = 0;i < numRows;i++){
            List<Integer> a = new ArrayList<>(i+1);
            if (i == 0){
                a.add(1);
            }else {
                a.add(1);
                for (int j = 1 ; j < i ; j++){
                    a.add(j,lists.get(i-1).get(j-1)+lists.get(i-1).get(j));
                }
                a.add(1);

            }
            lists.add(a);
        }

        return lists;
    }

}
