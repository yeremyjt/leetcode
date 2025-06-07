package org.yeremy.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), ans, used, nums);
        return ans;
    }

    private void backtrack(List<Integer> curr, List<List<Integer>> ans, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip used elements
            if (used[i]) continue;

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            curr.add(nums[i]);

            // Continue the exploration
            backtrack(curr, ans, used, nums);

            // Revert the choice for the next exploration
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
    
}

/*
 * # Permutations II Algorithm

## Algorithm Overview
- Uses backtracking to generate all unique permutations of an array with possible duplicates
- Sorts the array first to group duplicate elements together
- Uses a boolean array to track which elements have been used in the current permutation
- Skips duplicate permutations with a special condition

## Key Components
- **Sorting**: Groups duplicates together to make them easier to identify
- **Boolean used[]**: Tracks which elements are already used in the current permutation path
- **Duplicate handling**: The condition `if (i > 0 && nums[i] == nums[i-1] && !used[i-1])` prevents using the same value at the same position in the recursion tree
- **Backtracking**: Add element → Recurse → Remove element pattern

## Duplicate Skipping Logic
- When we encounter a duplicate number (nums[i] == nums[i-1]), we only use it if its previous duplicate is already used (!used[i-1] is false)
- This ensures we use duplicates in order and never generate the same permutation twice

## Time Complexity
- **Overall**: O(n × n!) where n is the length of the input array
- Sorting takes O(n log n)
- There are at most n! unique permutations
- Each permutation takes O(n) time to construct

## Space Complexity
- **Overall**: O(n + n!)
- O(n) for the recursion stack
- O(n) for the boolean used[] array
- O(n) for the current permutation list
- O(n × n!) for storing all permutations in the result (not counting output space)
 */
