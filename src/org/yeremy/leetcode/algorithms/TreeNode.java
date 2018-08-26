package org.yeremy.leetcode.algorithms;
/*
Generic tree node class used by most binary tree problems
 */
public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}
