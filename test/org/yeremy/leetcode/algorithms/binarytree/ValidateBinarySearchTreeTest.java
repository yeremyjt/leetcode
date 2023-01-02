package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.binarytree.TreeNode;
import org.yeremy.leetcode.algorithms.binarytree.ValidateBinarySearchTree;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {
    @Test
    public void isValidBST_Valid_ReturnTrue() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean ans = validateBinarySearchTree.isValidBST(root);

        assertTrue(ans);
    }

    @Test
    public void isValidBST_Invalid_ReturnsFalse() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean ans = validateBinarySearchTree.isValidBST(root);

        assertFalse(ans);
    }

    @Test
    public void isValidBST_Invalid_1_ReturnsFalse() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        boolean ans = validateBinarySearchTree.isValidBST(root);

        assertFalse(ans);
    }
}