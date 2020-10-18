package LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 删除链表的倒数第N个结点
 * @author: 宋丽
 * @create: 2020-10-18 16:20
 **/
public class RemoveNthFromEnd {
    /**
     * 快慢指针
     * 哑结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
