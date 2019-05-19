package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.TreeNode;

public class LowestCommonAncestorBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        if (right == null && left == null) return null;

        return left != null ? left : right;
    }
}
