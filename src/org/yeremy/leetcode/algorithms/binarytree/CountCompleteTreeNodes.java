package org.yeremy.leetcode.algorithms.binarytree;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;

        int d = computeDepth(root);
        // If the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2^d - 1 (left -> right)
        // Perform binary search to check how many nodes exist.
        int left = 1, right = (int) Math.pow(2, d) - 1;
        int pivot;
        while (left != right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root))
                left = pivot + 1;
            else
                right = pivot - 1;
        }

        // The tree contains 2^d - 1 nodes on the first (d - 1) levels
        // and left or (left + 1) nodes on the last level.
        int result = (int) Math.pow(2, d) - 1 + left;
        if (exists(left, d, root)) result++;
        return result;
    }

    // Return tree depth in O(d) time
    private int computeDepth(TreeNode node) {
        int d = 0;
        while(node.left != null) {
            node = node.left;
            d++;
        }
        return d;
    }

    // Last level are enumerated from 0 to 2^d - 1 (left -> right)
    // Return true if last level node idx exists.
    // Binary search with O(d) complexity
    private boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int pivot;
        for (int i = 0; i < d; i++) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            }
            else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }
}
