package org.yeremy.leetcode.algorithms;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root)
    {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;}

  private static class TreeNode
  {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x)
      {
          val = x;
      }
  }
}
