package org.yeremy.leetcode.algorithms;

import org.yeremy.leetcode.algorithms.ListNode;
import org.yeremy.leetcode.algorithms.ReverseLinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest
{
    @Test
    public void testReverseLinkedListIterative()
    {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = reverseLinkedList.reverseListIterative(node);

        assertEquals(5, head.val);
        assertEquals(4, head.next.val);
        assertEquals(3, head.next.next.val);
        assertEquals(2, head.next.next.next.val);
        assertEquals(1, head.next.next.next.next.val);
    }

    @Test
    public void testReverseLinkedListRecursively()
    {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = reverseLinkedList.reverseListRecursively(node);

        assertEquals(5, head.val);
        assertEquals(4, head.next.val);
        assertEquals(3, head.next.next.val);
        assertEquals(2, head.next.next.next.val);
        assertEquals(1, head.next.next.next.next.val);
    }
}