package org.yeremy.leetcode.algorithms;
/*
Generic tree node class used by most binary tree problems
 */
public class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val)
    {
        this.val = val;
        left = null;
        right = null;
    }
}
