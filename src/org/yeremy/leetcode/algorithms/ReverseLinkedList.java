package org.yeremy.leetcode.algorithms;

public class ReverseLinkedList
{
    public ListNode reverseListIterative(ListNode head) {
        if (head == null) return null;

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
