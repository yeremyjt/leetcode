package org.yeremy.leetcode.algorithms.binarytree;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.yeremy.leetcode.algorithms.binarytree.FindDuplicateSubtrees;
import org.yeremy.leetcode.algorithms.binarytree.TreeNode;
import org.junit.Test;

public class FindDuplicateSubtreesTest {
    
    @Test
    public void testFindDuplicateSubtrees() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
        List<TreeNode> actual = findDuplicateSubtrees.findDuplicateSubtrees(root);

        List<TreeNode> expected = Arrays.asList(root.left.left, root.left);
        assertTrue(expected.containsAll(actual));
    }
}
