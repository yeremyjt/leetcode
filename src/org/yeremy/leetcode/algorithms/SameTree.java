package org.yeremy.leetcode.algorithms;

public class SameTree
{
    public static void main(String[] args)
    {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q)
    {
        if ((p == null && q != null) || (p != null && q == null))
            return false;
        if (p != null && q != null)
        {
            if (p.val != q.val)
            {
                return false;
            }
        }
        if (p == null && q == null)
        {
            return true;
        }
        if (isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        else
            return false;
    }

    private static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

