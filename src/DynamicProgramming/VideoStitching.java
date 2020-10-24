package DynamicProgramming;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

/**
 * @program: Exercises
 * @description: 视频拼接
 * @author: 宋丽
 * @create: 2020-10-24 13:56
 **/
public class VideoStitching {
    /**
     * 我的解法
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching(int[][] clips, int T) {

        //排序，将所给区间集按照从小到大的顺序进行排序
        Arrays.sort(clips,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] - o2[0];
            }
        });

        //如果所给区间集长度为0，或者最小区间的左边不为0
        //说明无法完成该任务，返回-1
        int len = clips.length;
        if(len == 0 || clips[0][0] != 0){
            return -1;
        }

        //建立一个栈来维护所需的区间集，返回值即为区间集大小的一半
        //start和end用来判断下一个区间，初始值设为排序后的第一个的左边和右边
        Deque<Integer> stake = new ArrayDeque<>();
        stake.addLast(clips[0][0]);
        int start = stake.peekLast();
        stake.addLast(clips[0][1]);
        int end = stake.peekLast();


        //判断是否完成任务
        if(end >= T){
            return stake.size() / 2;
        }

        //遍历每一行排序后的所给区间集
        for (int i = 1; i < len; i++) {
            //当前区间的右边必须大于end
            if (clips[i][1] > end){
                //如果当前区间的左边也大于end，说明无法完成任务，返回-1
                if (clips[i][0] > end){
                    return -1;
                    //如果当前区间的左边<=start,说明上一区间可以被当前区间取代，
                    //更新栈的最后一个值即可，
                    //如果想获得所需片段的具体值，可以去除上一区间的值，放入当前区间的值
                }else if (clips[i][0] <= start){
                    stake.removeLast();
                    stake.addLast(clips[i][1]);
                    //如果当前区间的左边在start和end中间
                    //更新start的值，放入当前区间的值
                }else {
                    start = end;
                    stake.addLast(clips[i][0]);
                    stake.addLast(clips[i][1]);
                }
            }
            //更新end的值
            end = stake.peekLast();
            //判断是否完成任务
            if(end >= T){
                return stake.size() / 2;
            }
        }

        //如果前面的操作没有完成任务，返回-1
        return -1;
    }

    /**
     * 动态规划
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching2(int[][] clips, int T) {
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }

    /**
     * 贪心算法
     * @param clips
     * @param T
     * @return
     */
    public int videoStitching3(int[][] clips, int T) {
        int[] maxn = new int[T];
        int last = 0, ret = 0, pre = 0;
        for (int[] clip : clips) {
            if (clip[0] < T) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
            }
        }
        for (int i = 0; i < T; i++) {
            last = Math.max(last, maxn[i]);
            if (i == last) {
                return -1;
            }
            if (i == pre) {
                ret++;
                pre = last;
            }
        }
        return ret;
    }
}
