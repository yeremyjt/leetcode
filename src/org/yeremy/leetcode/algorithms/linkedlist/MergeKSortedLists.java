package org.yeremy.leetcode.algorithms.linkedlist;

import org.yeremy.leetcode.algorithms.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            while (lists[i] != null) {
                pq.add(lists[i].val);
                lists[i] = lists[i].next;
            }
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!pq.isEmpty()) {
            current.next = new ListNode(pq.poll());
            current = current.next;
        }

        return head.next;
    }
}

