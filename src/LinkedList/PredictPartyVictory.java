package LinkedList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: Exercises
 * @description: Dota2参议院
 * @author: 宋丽
 * @create: 2020-12-11 10:59
 **/
public class PredictPartyVictory {
    /**
     * 用队列记录每个参议员的投票时间
     * @param senate
     * @return
     */
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        int i = 0;
        for (char c : senate.toCharArray()) {
            if (c == 'R') {
                radiant.offer(i++);
            } else {
                dire.offer(i++);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            System.out.println(radiantIndex);
            System.out.println(direIndex);
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}
