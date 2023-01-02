package org.yeremy.leetcode.algorithms.binarytree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalTwo {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        queue.add(root);
        if (root == null) return result;

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek().left != null) queue.add(queue.peek().left);
                if (queue.peek().right != null) queue.add(queue.peek().right);
                levelList.add(queue.poll().val);
            }

            // Inserts the specified element at the specified position in this list. Shifts the element currently at
            // that position (if any) and any subsequent elements to the right (adds one to their indices).
            result.add(0, levelList);
        }

        return result;
    }
}
