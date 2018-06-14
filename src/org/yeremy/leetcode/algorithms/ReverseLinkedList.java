package org.yeremy.leetcode.algorithms;

import java.util.Stack;

public class ReverseLinkedList
{
    public ListNode reverseListIterative(ListNode head) {
        if (head == null) return null;

        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        stack.push(node);

        while (node.next != null) {
            stack.push(node.next);
            node = node.next;
        }

        head = node;

        while(!stack.empty()) {
            node.next = stack.pop();
            node = node.next;
        }

        node.next = null;

        return head;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
