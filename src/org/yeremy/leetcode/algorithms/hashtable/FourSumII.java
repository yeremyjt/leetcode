package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashMap;

/*
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0


Example 1:

Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1


Constraints:

n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228

SOLUTION: https://leetcode.com/problems/4sum-ii/editorial/
a + b + c + d = 0;
a + b = -(c + d)

TIME COMPLEXITY: O(n^2)
SPACE COMPLEXITY: O(n^2)
 */
public class FourSumII {
    private HashMap<Integer, Integer> sums = new HashMap<>();
    private int zeroSumCount = 0;

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // Getting sums for first two arrays and putting themm in the hashmap of sums.
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                sums.put(sum, sums.getOrDefault(sum, 0) + 1);
            }
        }

        // Getting negative sum of the last two arrays and getting the count of zero sums.
        for (int c : nums3) {
            for (int d : nums4) {
                int negativeSum = (c + d) * -1;
                zeroSumCount += sums.getOrDefault(negativeSum, 0);
            }
        }

        return zeroSumCount;
    }
}
