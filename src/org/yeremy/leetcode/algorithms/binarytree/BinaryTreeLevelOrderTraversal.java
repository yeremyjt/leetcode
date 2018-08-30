package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return lists;

        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelCount; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }
            lists.add(list);
        }
        return lists;
    }
}
