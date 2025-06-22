package org.yeremy.leetcode.algorithms.binarytree;

/*
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

 

Example 1:

Input: root = [1,2,3,null,5,null,4]

Output: [1,3,4]

Explanation:



Example 2:

Input: root = [1,2,3,4,null,null,null,5]

Output: [1,3,4,5]

Explanation:



Example 3:

Input: root = [1,null,3]

Output: [1,3]

Example 4:

Input: root = []

Output: []

 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */
import java.util.*;

public class BinaryTreeRightSideView {    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return result;
    }
}

/*
 ## Time and Space Complexity

**Time Complexity**: `O(n)`
- We visit each node in the binary tree exactly once
- Where `n` is the total number of nodes in the tree

**Space Complexity**: `O(w)`
- The queue stores at most one level of nodes at a time
- Where `w` is the maximum width of the tree (maximum number of nodes at any level)
- In the worst case (complete binary tree), this is `O(n/2) = O(n)`
- In the best case (skewed tree), this is `O(1)`

 */
