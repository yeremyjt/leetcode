package org.yeremy.leetcode.algorithms.binarytree;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BinaryTreeLevelOrderTraversalTest {
    
    @Test
    public void testLevelOrderIterative() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal levelOrder = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> solution = levelOrder.levelOrderIterative(root);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7));
        assertTrue(solution.equals(expected));
    }

    @Test
    public void testLevelOrderRecursive() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversal levelOrder = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> solution = levelOrder.levelOrderRecursive(root);
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7));
        assertTrue(solution.equals(expected));
    }
}
