package com.kyong.suixianglu.b链表;

import java.util.HashSet;
import java.util.Set;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/11 17:12
 */
//142. 环形链表 II
public class g环形链表 {
    //暴力
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode cur = head;
        while(!visited.contains(cur) && cur!=null){
            visited.add(cur);
            cur = cur.next;
        }
        return cur;
    }
    //快慢指针 快的走两步，慢的一步
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
