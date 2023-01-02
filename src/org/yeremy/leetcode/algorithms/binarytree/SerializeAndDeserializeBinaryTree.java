package org.yeremy.leetcode.algorithms.binarytree;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        List<Integer> serialized = new ArrayList<>();
        dfsSerialize(root, serialized);
        return serialized.toString().replace(" ", "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.replace("[","");
        data = data.replace("]", "");
        String[] nodes = data.split(",");
        if (nodes.length == 0 || data.isEmpty()) return null;
        Queue<String> nodesQueue = new LinkedList<>();

        for (int i = 0; i < nodes.length; i++) {
            nodesQueue.add(nodes[i]);
        }

        return dfsDeserialize(nodes, nodesQueue);
    }

    private TreeNode dfsDeserialize(String[] nodes, Queue<String> nodesQueue) {
        if (nodesQueue.peek().equals("null")) {
            nodesQueue.poll();
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodesQueue.poll()));
        node.left = dfsDeserialize(nodes, nodesQueue);
        node.right = dfsDeserialize(nodes, nodesQueue);
        return node;
    }

    private void dfsSerialize(TreeNode root, List<Integer> serialized) {
        if (root == null) {
            serialized.add(null);
            return;
        }

        serialized.add(root.val);
        dfsSerialize(root.left, serialized);
        dfsSerialize(root.right, serialized);
    }
}
