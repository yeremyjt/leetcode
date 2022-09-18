package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.


Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
 */
public class ContainsDuplicateII {
    /*
    Algorithm:
    - Keep a map of number and index.
    - When number is already found in the map, we know that nums[i] == nums[j]
    - Calculate abs(i - j) <= k. We get i by the value in the map.
    - If true, return true, else update the map value to the latest index.
    this will make the subtraction more likely to be <= k.

    Time complexity: O(n) since we loop through the array once.
    Space complexity: O(min(n, k) since we create a hash table of at most n numbers, or whenever the substraction is lower than k.
     */

    // Map of number and its index.
    private final Map<Integer, Integer> map = new HashMap<>();

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}
