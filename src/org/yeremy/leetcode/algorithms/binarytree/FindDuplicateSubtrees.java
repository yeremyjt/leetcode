package org.yeremy.leetcode.algorithms.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]
 

Constraints:

The number of the nodes in the tree will be in the range [1, 5000]
-200 <= Node.val <= 200

 */
public class FindDuplicateSubtrees {
    
    /* Algorithm:
     * Traverse the tree in post order and serialize all subtrees like this: "(left-root-right)"     
     * Map all serializations where key is the serialization and value is the count of times serialization is found. A value greater than 1 means it's a duplicate tree.
     * Iterate through values of map and put in a list all roots where list of nodes is greater than one.
     * 
     * Time complexity: O(N) since we go through all nodes in the tree once.
     * Space complexity: O(N) since we create a map and a list where in the worse case, all trees are duplicate.
     * 
     */
    
    private List<TreeNode> duplicates = new ArrayList<>();
    private Map<String, List<TreeNode>> serializationMap = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {        
        serialize(root);  
        
        for (List<TreeNode> group : serializationMap.values()) {
            if (group.size() > 1) {
                duplicates.add(group.get(0));
            }
        }
        return duplicates;
    }

    private String serialize(TreeNode root) {        
        if (root == null) {
            return "#";
        }

        String left = serialize(root.left);
        String right = serialize(root.right);
        
        String serialized = "(" + left + "-" + root.val + "-" + right + ")";
        
        if (!serializationMap.containsKey(serialized)) {
            serializationMap.put(serialized, new ArrayList<TreeNode>());
        }

        serializationMap.get(serialized).add(root);

        return serialized;
    }
}
