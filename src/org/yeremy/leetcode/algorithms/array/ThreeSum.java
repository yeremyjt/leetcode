package org.yeremy.leetcode.algorithms.array;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 10


Time Complexity: O(N) as we iterate through the elements at most twice.
Space Complexity: O(N) to store elements in the hashset.
 */


import java.sql.Array;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //return twoPointerSolution(nums);
        return hashSetSolution(nums);

    }

    private List<List<Integer>> twoPointerSolution(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> threeSumList = Arrays.asList(nums[i], nums[j], nums[k--]);
                    set.add(threeSumList);
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(set);
    }

    private List<List<Integer>> hashSetSolution(int[] nums) {
        List<List<Integer>> threeSumLists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(threeSumLists, nums, i);
            }
        }

        return threeSumLists;
    }

    private void twoSum(List<List<Integer>> threeSumLists, int[]nums, int i) {
        Set<Integer> set = new HashSet<>();
        int j = i + 1;

        while (j < nums.length) {
            int complement = -nums[i] - nums[j];
            if (set.contains(complement)) {
                List<Integer> threeSumList = Arrays.asList(nums[i], nums[j], complement);
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            set.add(nums[j]);
        }
    }
 }
