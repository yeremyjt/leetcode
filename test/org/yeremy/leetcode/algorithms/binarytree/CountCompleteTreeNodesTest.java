package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.binarytree.CountCompleteTreeNodes;
import org.yeremy.leetcode.algorithms.binarytree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountCompleteTreeNodesTest {

    @Test
    public void countNodes() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);

        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        int ans = countCompleteTreeNodes.countNodes(root);
        assertEquals(12, ans);
    }
}