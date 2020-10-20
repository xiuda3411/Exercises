package LinkedList;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 重排链表
 * @author: 宋丽
 * @create: 2020-10-20 19:46
 **/
public class ReorderList {
    /**
     * 我的方法
     * 用线性表记录每个结点位置
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode p = head;
        List<ListNode> list = new LinkedList<>();
        while(p != null){
            list.add(p);
            p = p.next;
        }

//        int j = nodes.size() - 1;
//        if(j < 2){
//            return;
//        }
//
//        for(int i = 0 ; i + 1 < j ; i++){
//            ListNode p1 = nodes.get(i);
//            ListNode p2 = nodes.get(i + 1);
//            ListNode p3 = nodes.get(j);
//            ListNode p4 = nodes.get(j-1);
//            p1.next = p3;
//            p3.next = p2;
//            p4.next = null;
//            j--;
//        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /**
     * 寻找链表中点+链表逆序＋合并链表
     * @param head
     */
    public void reorderList2(ListNode head) {
        ListNode mid = mid(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reserve(l2);
        merge(l1,l2);
    }

    private void merge(ListNode l1, ListNode l2) {
        ListNode p1,p2;
        while (l1 != null && l2 != null){
            p1 = l1.next;
            p2 = l2.next;

            l1.next = l2;
            l1 = p1;

            l2.next = l1;
            l2 = p2;
        }
    }

    private ListNode reserve(ListNode l2) {
        ListNode prev = null;
        ListNode curr = l2;
        while (curr != null){
            ListNode nodeTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nodeTemp;
        }
        return prev;
    }

    private ListNode mid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
