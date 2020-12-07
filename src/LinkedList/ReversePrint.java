package LinkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: Exercises
 * @description: 从头到尾打印链表
 * @author: 宋丽
 * @create: 2020-12-05 15:19
 **/
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stake = new ArrayDeque<>();
        while(head != null){
            stake.push(head.val);
            head = head.next;
        }
        int[] res = new int[stake.size()];
        int i = 0;
        while (stake.size() != 0){
            res[i] = stake.pop();
            i++;
        }

        return res;
    }
}
