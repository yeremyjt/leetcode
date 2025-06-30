package org.yeremy.leetcode.algorithms.binarytree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.

 

Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
 

Constraints:

The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
 */
public class BinaryTreePaths {
    // Time: O(N + L*H) where L=leaves, H=height
    // Space: O(H) for algorithm + O(L*H) for result = O(N log N) total
    // This is optimal - cannot do better than O(N log N) for this problem
    public List<String> binaryTreePaths(TreeNode root) {        
        List<String> ans = new ArrayList<>(); 
        dfs(ans, root, new StringBuilder());
        return ans;
    }

    private void dfs(List<String> ans, TreeNode curr, StringBuilder path) {
        int originalLength = path.length();
        path.append(curr.val);

        if (curr.left == null && curr.right == null) {
            ans.add(path.toString());
        }

        if (curr.left != null) {
            path.append("->");
            dfs(ans, curr.left, path);
            path.setLength(path.length() - 2);
        }
        if (curr.right != null) {
            path.append("->");
            dfs(ans, curr.right, path);
            path.setLength(path.length() - 2);
        }
        
        path.setLength(originalLength);
    }
}
