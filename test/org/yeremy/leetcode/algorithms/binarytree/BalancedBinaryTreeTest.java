package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.binarytree.BalancedBinaryTree;
import org.yeremy.leetcode.algorithms.binarytree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalancedBinaryTreeTest
{
    @Test
    public void testIsBalanced_True()
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        assertTrue(balancedBinaryTree.isBalanced(root));
    }

    @Test
    public void testIsBalanced_False()
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        assertTrue(!balancedBinaryTree.isBalanced(root));
    }
}