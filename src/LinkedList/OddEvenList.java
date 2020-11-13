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

    /**
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // head 为奇链表头结点，o 为奇链表尾节点
        ListNode o = head;
        // p 为偶链表头结点
        ListNode p = head.next;
        // e 为偶链表尾节点
        ListNode e = p;
        while (o.next != null && e.next != null) {
            o.next = e.next;
            o = o.next;
            e.next = o.next;
            e = e.next;
        }
        o.next = p;
        return head;
    }
}
