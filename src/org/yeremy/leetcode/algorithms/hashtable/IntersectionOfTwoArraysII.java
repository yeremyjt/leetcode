package org.yeremy.leetcode.algorithms.hashtable;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.*;

public class IntersectionOfTwoArraysII {
    // Maps of numbers in the array and their count.
    private final Map<Integer, Integer> nums1UniqueMap = new HashMap<>();
    private final Map<Integer, Integer> nums2UniqueMap = new HashMap<>();

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();

        // Getting map of unique numbers and their counts in each array.
        for (int number : nums1) {
            nums1UniqueMap.put(number, nums1UniqueMap.getOrDefault(number, 0) + 1);
        }

        for (int number : nums2) {
            nums2UniqueMap.put(number, nums2UniqueMap.getOrDefault(number, 0) + 1);
        }

        for (Integer number : nums1UniqueMap.keySet()) {
            if (nums2UniqueMap.containsKey(number)) {
                for (int i = 0; i < Math.min(nums1UniqueMap.get(number), nums2UniqueMap.get(number)); i++) {
                    result.add(number);
                }
            }
        }

        int[] resultArray = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
