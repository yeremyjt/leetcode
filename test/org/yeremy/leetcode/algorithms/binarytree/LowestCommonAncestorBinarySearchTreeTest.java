package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.binarytree.LowestCommonAncestorBinarySearchTree;
import org.yeremy.leetcode.algorithms.binarytree.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LowestCommonAncestorBinarySearchTreeTest {
    @Test
    public void testLowestCommonAncestor() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LowestCommonAncestorBinarySearchTree lowestCommonAncestorBinarySearchTree = new LowestCommonAncestorBinarySearchTree();
        TreeNode lowest = lowestCommonAncestorBinarySearchTree.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        assertEquals(2, lowest.val);
    }
}