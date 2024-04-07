package com.pioneertao.algorithm;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。不满K个不翻转
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        //边界条件：链表里面没有节点，或只有1个节点，或k==1和0，不需要交换
        if (head == null || head.next == null || k == 0 || k == 1) return head;

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode first = head;
        ListNode last = first;
        while (first != null) {
            for (int i = 0; i < k - 1; i++) {
                last = last.next;
                if (last == null) return dummyNode.next; //不满k个就不反转，返回头节点
            }
            ListNode next = last.next;
            last.next = null;

            reverse(first);

            prev.next = last;
            first.next = next;

            prev = first;
            first = next;
            last = first;
        }
        return dummyNode.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;

            pre = curr;
            curr = next;
        }
        return pre;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}