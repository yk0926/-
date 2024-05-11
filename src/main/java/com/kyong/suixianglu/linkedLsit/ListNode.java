package com.kyong.suixianglu.linkedLsit;

/**
 * @author kyong
 * @date 2023/4/10 18:20
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
