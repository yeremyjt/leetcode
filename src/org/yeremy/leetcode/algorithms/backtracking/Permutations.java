package org.yeremy.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

public class Permutations {
    /*     
    Initialize an answer array ans and an array curr to build permutations with.
    Create a backtrack function that takes curr as an argument:
    If curr.length == nums.length, add a copy of curr to ans and return.
    Iterate over nums. For each num, if num is not in curr, do the following:
    Add num to curr and call backtrack(curr), then remove num from curr.
    Call backtrack with an initially empty curr.
    Return ans.
    Note that we are essentially implementing a DFS traversal of an imaginary tree. The children of a node are all the numbers that haven't been used yet.

    Time complexity: O(n.n!)
    Space complexity: O(n)
    */     
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    private void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }        
    }
}
