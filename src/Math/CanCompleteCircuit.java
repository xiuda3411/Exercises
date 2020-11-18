package Math;

/**
 * @program: Exercises
 * @description: 加油站
 * @author: 宋丽
 * @create: 2020-11-18 10:13
 **/
public class CanCompleteCircuit {
    /**
     * 关键在于如果
     * 一路上所获得的汽油总量 > 一路上会消耗的汽油总量
     * 那么一定有解
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int run = 0;
        int rest = 0;
        for(int i = 0 ; i < gas.length ; i++){
            rest += gas[i] - cost[i];
            run += gas[i] - cost[i];
            if(run < 0){
                run = 0;
                start = i + 1;
            }
        }
        return rest >= 0 ? start : -1;
    }
}
