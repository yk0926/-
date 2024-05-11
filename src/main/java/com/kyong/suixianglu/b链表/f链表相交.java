package com.kyong.suixianglu.b链表;

import java.util.HashSet;
import java.util.Set;

/**
 * Description
 *
 * @author kyong
 * @version 1.0
 * @date 2024/5/11 16:26
 */
//160.链表相交
public class f链表相交 {
    //暴力
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = new ListNode(0);
        curA.next = headA;
        ListNode curB = new ListNode(0);
        curB.next = headB;
        int lenA = 0;
        int lenB = 0;
        while(curA.next != null){
            curA = curA.next;
            lenA++;
        }
        curA = headA;
        while(curB.next != null){
            curB = curB.next;
            lenB++;
        }
        curB = headB;
        int skip = 0;
        if(lenA<lenB){
            skip = lenB - lenA;
            for(int i = 0; i< skip ; i++){
                curB = curB.next;
            }
        }else{
            skip = lenA - lenB;
            for(int i = 0; i< skip ; i++){
                curA = curA.next;
            }
        }
        while(curA != null){
            if(curA == curB){
                return curA;
            }else{
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }

    //哈希表
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
