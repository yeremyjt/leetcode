package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirrorDfs(root, root);
        //return isMirrorBfs(root);
    }

    private boolean isMirrorDfs(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val
            && isMirrorDfs(t1.left, t2.right)
            && isMirrorDfs(t1.right, t2.left));
    }

    private boolean isMirrorBfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}
