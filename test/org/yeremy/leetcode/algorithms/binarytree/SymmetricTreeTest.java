package org.yeremy.leetcode.algorithms.binarytree;

import org.junit.Test;
import org.yeremy.leetcode.algorithms.TreeNode;

import static org.junit.Assert.*;

public class SymmetricTreeTest {

    @Test
    public void isSymmetric_Symmetric_ReturnsTrue() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        SymmetricTree symmetricTree = new SymmetricTree();
        boolean ans = symmetricTree.isSymmetric(root);
        assertTrue(ans);
    }

    @Test
    public void isSymmetric_Asymmetric_ReturnsFalse() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        SymmetricTree symmetricTree = new SymmetricTree();
        boolean ans = symmetricTree.isSymmetric(root);
        assertFalse(ans);
    }
}