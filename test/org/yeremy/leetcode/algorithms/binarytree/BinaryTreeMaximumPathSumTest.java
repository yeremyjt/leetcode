package org.yeremy.leetcode.algorithms.binarytree;

import org.junit.Test;
import org.yeremy.leetcode.algorithms.TreeNode;

import static org.junit.Assert.*;

public class BinaryTreeMaximumPathSumTest {

    @Test
    public void maxPathSum() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        int ans = binaryTreeMaximumPathSum.maxPathSum(root);
        assertEquals(42, ans);
    }

    @Test
    public void maxPathSum_1() {
        TreeNode root = new TreeNode(-3);
        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        int ans = binaryTreeMaximumPathSum.maxPathSum(root);
        assertEquals(-3, ans);
    }
}