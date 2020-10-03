package LinkedList;

/**
 * @program: Exercises
 * @description: 奇偶链表
 * @author: 宋丽
 * @create: 2020-10-03 21:37
 **/
public class OddEvenList {
    /**
     * 我的解法
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode p1 = head;
        if (p1 == null){
            return head;
        }
        ListNode p2 = head.next;
        if (p2 == null){
            return head;
        }
        while (p2.next != null){
            ListNode p3 = p2.next;
            p2.next = p3.next;
            p3.next = p1.next;
            p1.next = p3;
            p1 = p1.next;
            p2 = p2.next;
            if (p2 == null){
                return head;
            }
        }
        return head;
    }
}
