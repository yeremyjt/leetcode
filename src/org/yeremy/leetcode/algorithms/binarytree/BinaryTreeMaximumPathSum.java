package org.yeremy.leetcode.algorithms.binarytree;

import org.yeremy.leetcode.algorithms.TreeNode;

import java.util.Arrays;
import java.util.Collections;

class BinaryTreeMaximumPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) return 0;

        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);

        int priceNewPath = root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewPath);

        return root.val + Math.max(leftGain, rightGain);
    }
}