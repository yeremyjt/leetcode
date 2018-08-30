package org.yeremy.leetcode.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?


 */
public class BinaryTreeInOrderTraversal {
    private List<Integer> inorderTraversalList = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root)
    {
        if (root != null)
        {
            if (root.left != null)
            {
                inorderTraversal(root.left);
            }

            inorderTraversalList.add(root.val);

            if (root.right != null)
            {
                inorderTraversal(root.right);
            }
        }

        return inorderTraversalList;
    }

    private class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
