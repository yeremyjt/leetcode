package org.yeremy.leetcode.algorithms.binarytree;

/*
 * Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 

Example 1:


Input: root = [1,2,5,3,4,null,6]
Output: [1,null,2,null,3,null,4,null,5,null,6]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [0]
Output: [0]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
 

Follow up: Can you flatten the tree in-place (with O(1) extra space)?
 */
public class FlattenBinaryTreeToLinkedList {
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        if (root == null) return;
        
        // Traverse in reverse preorder: right -> left -> root
        flatten(root.right);
        flatten(root.left);
        
        // Current node's right points to the previous node
        root.right = prev;
        // Left pointer is always null
        root.left = null;
        // Update previous node to current node
        prev = root;
    }
}

/*
 * ### Time Complexity: O(n)
- Each node is visited exactly once during the recursive traversal
- The operations at each node are constant time (O(1))
- Total: O(n)

### Space Complexity: O(h)
- Uses O(h) space for the recursion stack, where h is the height of the tree
- Best case (balanced tree): O(log n)
- Worst case (skewed tree): O(n)

### Key Insight
The key insight in this solution is using a reverse preorder traversal (right -> left -> root):

1. We maintain a class member variable `prev` to keep track of the previously processed node
2. By traversing in reverse order (right subtree first, then left, then root), we build the flattened list from the end to the beginning
3. For each node:
   - Set its right pointer to the previously processed node
   - Set its left pointer to null
   - Update the previous node to be the current node

 */