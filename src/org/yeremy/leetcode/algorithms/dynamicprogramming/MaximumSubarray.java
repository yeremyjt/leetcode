package org.yeremy.leetcode.algorithms.dynamicprogramming;
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int max = A[0], maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            maxSoFar = Math.max(maxSoFar + A[i], A[i]);
            max = Math.max(max, maxSoFar);
        }
        return max;
    }
}
