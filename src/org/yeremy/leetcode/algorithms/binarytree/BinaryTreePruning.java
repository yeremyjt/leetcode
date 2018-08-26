package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.TreeNode;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        if (root.val == 0 &&
                (root.left == null) && (root.right == null)) {
            root = null;
        }

        return root;
    }
}
