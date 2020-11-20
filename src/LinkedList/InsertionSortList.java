package LinkedList;

/**
 * @program: Exercises
 * @description: 对链表进行插入排序
 * @author: 宋丽
 * @create: 2020-11-20 21:05
 **/
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode n = new ListNode(0);
        n.next = head;
        insertSort(n,head);
        return n.next;
    }
    private void insertSort(ListNode head,ListNode end){
        if(end == null || end.next == null){
            return;
        }

        ListNode n = end.next;
        ListNode l = head.next;
        ListNode pre = head;
        if(end.val <= n.val){
            end = n;
        }else if(l.val >= n.val){
            end.next = n.next;
            n.next = l;
            pre.next = n;
        }else {
            while(l.val < n.val){
                l = l.next;
                pre = pre.next;
            }
            end.next = n.next;
            n.next = l;
            pre.next = n;
        }
        insertSort(head,end);
    }
}
