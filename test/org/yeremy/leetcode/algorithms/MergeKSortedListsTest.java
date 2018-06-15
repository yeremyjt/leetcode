package org.yeremy.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeKSortedListsTest {
    @Test
    public void testMergeKSortedLists() {
        ListNode[] lists = new ListNode[3];
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        lists[0] = list1;
        lists[1] = list2;
        lists[2] = list3;

        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        ListNode merged = mergeKSortedLists.mergeKLists(lists);
        assertEquals(1, merged.val);
        assertEquals(1, merged.next.val);
        assertEquals(2, merged.next.next.val);
        assertEquals(3, merged.next.next.next.val);
        assertEquals(4, merged.next.next.next.next.val);
        assertEquals(4, merged.next.next.next.next.next.val);
        assertEquals(5, merged.next.next.next.next.next.next.val);
        assertEquals(6, merged.next.next.next.next.next.next.next.val);
    }

}