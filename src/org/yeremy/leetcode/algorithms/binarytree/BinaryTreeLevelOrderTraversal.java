package org.yeremy.leetcode.algorithms.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> levelOrderIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return levels;

        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {
            levels.add(new ArrayList<>());
            int levelCount = queue.size();

            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);                
            }
            level++;
        }

        return levels;
    }

    public List<List<Integer>> levelOrderRecursive(TreeNode root) {        
        if (root == null) return levels;

        bfs(root, 0);
        return levels;
    }

    private void bfs(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(node.val);

        if (node.left != null) bfs(node.left, level + 1);
        if (node.right != null) bfs(node.right, level + 1);
    }
}
