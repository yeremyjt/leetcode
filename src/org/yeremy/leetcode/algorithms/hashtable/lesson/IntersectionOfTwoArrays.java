package org.yeremy.leetcode.algorithms.hashtable.lesson;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
 * Each element in the result must be unique and you may return the result in any order.


Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */
public class IntersectionOfTwoArrays {
    private Set<Integer> tempSet = new HashSet<>();
    private Set<Integer> intersection = new HashSet<>();

    public int[] intersection(int[] nums1, int[] nums2) {
        // Unique elements in nums1
        for (int i = 0; i < nums1.length; i++) {
            tempSet.add(nums1[i]);
        }

        // Unique elementsin nums2
        for (int i = 0; i < nums2.length; i++) {
            if (tempSet.contains(nums2[i])) {
                intersection.add(nums2[i]);
            }
        }

        int[] result = new int[intersection.size()];

        int index = 0;

        for (int item : intersection) {
            result[index++] = item;
        }

        return result;
    }
   
}
