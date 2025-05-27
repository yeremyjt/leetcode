package org.yeremy.leetcode.algorithms.binarytree;

/*
 * Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element of the linked list.

 

Example 1:



Input: root = [4,2,5,1,3]


Output: [1,2,3,4,5]

Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.

Example 2:

Input: root = [2,1,3]
Output: [1,2,3]
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
All the values of the tree are unique.
 */
public class ConvertBInarySearchTreeToSortedDoublyLinkedList {

    /*
    1. The solution uses an in-order traversal approach because:
    - In-order traversal of a BST visits nodes in sorted order
    - This naturally gives us the correct order for our doubly linked list
    2. The main method treeToDoublyList:
    - Takes a root node as input
    - Returns null if the tree is empty
    - Uses in-order traversal to convert the tree to a doubly linked list
    - Makes the list circular by connecting the first and last nodes
    - Returns the pointer to the smallest element (first node)
    3. The inorderTraversal helper method:
    - Maintains two pointers: first (smallest element) and last (current last element)
    - For each node:
        - Processes left subtree
        - Links current node with the last processed node
        - Updates the last pointer
        - Processes right subtree

    The time complexity is O(n) where n is the number of nodes in the tree, as we visit each node exactly once. The space complexity is O(h) where h is the height of the tree, due to the recursion stack.
     */
    private Node first = null;
    private Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        
        // Perform in-order traversal to convert BST to sorted DLL
        inorderTraversal(root);
        
        // Make it circular by connecting first and last nodes
        first.left = last;
        last.right = first;
        
        return first;
    }
    
    private void inorderTraversal(Node node) {
        if (node == null) return;
        
        // Process left subtree
        inorderTraversal(node.left);
        
        // Process current node
        if (last != null) {
            // Link the last node with current node
            last.right = node;
            node.left = last;
        } else {
            // This is the first node
            first = node;
        }
        last = node;
        
        // Process right subtree
        inorderTraversal(node.right);
    }
}
