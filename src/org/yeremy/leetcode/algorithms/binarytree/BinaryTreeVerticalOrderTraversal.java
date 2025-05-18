package org.yeremy.leetcode.algorithms.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BinaryTreeVerticalOrderTraversal {
    /**
     * Algorithm for Binary Tree Vertical Order Traversal:
     * 1. Assign a column number to each node in the tree:
     *    - Root node is at column 0
     *    - Left child is at (parent's column - 1)
     *    - Right child is at (parent's column + 1)
     * 2. Use BFS (level-order traversal) to visit nodes from top to bottom
     * 3. Group nodes by their column number
     * 4. For each column, maintain the order of nodes as they appear in the BFS
     * 5. Return the result as a list of columns from leftmost to rightmost
     * 
     * Time Complexity: O(n) where n is the number of nodes in the tree
     * Space Complexity: O(n) for the queue and hashmap
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {        
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> solution = new ArrayList<>();
        // HashMap to store columns and the list of nodes.
        HashMap<Integer, List<Integer>> columns = new HashMap<>();
        int minColumn = 0;
        int maxColumn = 0;
        
        // Use a queue to perform BFS
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        
        nodeQueue.add(root);
        colQueue.add(0); // Root is at column 0
        
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int column = colQueue.poll();
            
            // Add current node to its column list
            columns.computeIfAbsent(column, k -> new ArrayList<>()).add(node.val);
            
            // Update min and max column
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);
            
            // Process left child
            if (node.left != null) {
                nodeQueue.add(node.left);
                colQueue.add(column - 1);
            }
            
            // Process right child
            if (node.right != null) {
                nodeQueue.add(node.right);
                colQueue.add(column + 1);
            }
        }
        
        // Build the result from left to right columns
        for (int i = minColumn; i <= maxColumn; i++) {
            solution.add(columns.get(i));
        }

        return solution;
    }
}