package org.yeremy.leetcode.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 * Note:
 *
 * Both of the given trees will have between 1 and 100 nodes.
 */
class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leavesTreeOne = getLeaves(root1);
        List<Integer> leavesTreeTwo = getLeaves(root2);

        return leavesTreeOne.equals(leavesTreeTwo);
    }

    private List<Integer> getLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();

        getLeaves(root, leaves);

        return leaves;
    }

    private void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;

        getLeaves(root.left, leaves);

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        getLeaves(root.right, leaves);
    }
}