package org.yeremy.leetcode.algorithms.linkedlist;

import org.yeremy.leetcode.algorithms.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int remainder = 0;

        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;

            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a + b + remainder;
            int value = sum % 10;
            remainder = sum / 10;

            head.next = new ListNode(value);
            head = head.next;
        }

        if (remainder > 0)
            head.next = new ListNode(remainder);

        return dummy.next;
    }
}
