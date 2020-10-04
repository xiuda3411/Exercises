package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: Exercises
 * @description: 相交链表
 * @author: 宋丽
 * @create: 2020-10-04 21:44
 **/
public class GetIntersectionNode {
    /**
     * 我的方法
     * 用set记录结点地址，出现相同即返回
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet set = new HashSet<>();
        ListNode h1 = headA,h2 = headB,h3 = null;
        while (h1 != null || h2 != null){
            int size = set.size();

            if (h1 != null){
                set.add(h1);
                if (size == set.size()){
                    return h1;
                }
                h1 = h1.next;
            }

            if (h2 != null){
                size = set.size();
                set.add(h2);
                if (size == set.size()){
                    return h2;
                }
                h2 = h2.next;
            }
        }
        return h3;
    }

    /**
     * 双指针法
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB){
        ListNode h1 = headA,h2 = headB;
        int flag = 0;
        if(h1 == null || h2 == null){
            return null;
        }
        while (h1 != h2){
            if (h1.next == null){
                h1 = headB;
                flag++;
            }else {
                h1 = h1.next;
            }
            if (h2.next == null){
                h2 = headA;
                flag++;
            }else {
                h2 = h2.next;
            }
            if (flag > 2){
                return null;
            }
        }
        return h1;
    }
}
