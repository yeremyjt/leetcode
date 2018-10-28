package org.yeremy.leetcode.algorithms.binarytree;

import org.junit.Test;
import org.yeremy.leetcode.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalTwoTest {
    @Test
    public void BinaryTreeLevelOrderTraversalTwoTest() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeLevelOrderTraversalTwo binaryTree = new BinaryTreeLevelOrderTraversalTwo();
        List<List<Integer>> result = binaryTree.levelOrderBottom(root);
        assertNotNull(result);
        assertEquals(3,result.size());
        assertEquals(new ArrayList<Integer>() {{ add(15); add(7); }}, result.get(0));
        assertEquals(new ArrayList<Integer>() {{ add(9); add(20); }}, result.get(1));
        assertEquals(new ArrayList<Integer>() {{ add(3); }}, result.get(2));
    }
}