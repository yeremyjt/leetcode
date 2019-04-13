package org.yeremy.leetcode.algorithms.binarytree;

import org.junit.Test;
import org.yeremy.leetcode.algorithms.TreeNode;

import static org.junit.Assert.*;

public class SerializeAndDeserializeBinaryTreeTest {

    @Test
    public void testSerialize() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        SerializeAndDeserializeBinaryTree alg = new SerializeAndDeserializeBinaryTree();
        String serialized = alg.serialize(root);
        assertEquals("[1,2,3,null,null,4,null,null,5,null,null]", serialized);

    }

    @Test
    public void testDeserialize() {
        String data = "[1,2,3,null,null,4,null,null,5,null,null]";
        SerializeAndDeserializeBinaryTree alg = new SerializeAndDeserializeBinaryTree();
        TreeNode root = alg.deserialize(data);
        assertEquals(1, root.val);
        assertEquals(2, root.left.val);
        assertEquals(3, root.left.left.val);
        assertEquals(4, root.left.right.val);
        assertEquals(5, root.right.val);
    }
}
