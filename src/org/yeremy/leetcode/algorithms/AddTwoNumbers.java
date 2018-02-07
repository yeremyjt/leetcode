package org.yeremy.leetcode.algorithms;

public class AddTwoNumbers
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;

        while (p!= null || q!= null)
        {
            int x = (p != null)? p.val : 0;
            int y = (q != null)? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10; // Since carry is an int, it will aways be 0 or 1
            curr.next = new ListNode(sum % 10); // This will always return the leftist number of the sum
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0)
        {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    private class ListNode
    {
        public int val;
        public ListNode next;

        public ListNode(int val)
        {
            this.val = val;
        }
    }

}
