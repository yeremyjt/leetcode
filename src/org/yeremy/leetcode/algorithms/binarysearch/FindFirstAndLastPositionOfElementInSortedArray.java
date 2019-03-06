package org.yeremy.leetcode.algorithms.binarysearch;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        int min = findMinIndex(0, nums.length - 1, nums, target);
        int max = findMaxIndex(0, nums.length - 1, nums, target);
        int[] range = new int[2];
        range[0] = min;
        range[1] = max;
        return range;
    }

    private int findMinIndex(int left, int right, int[] nums, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (mid - 1 < 0) return mid;
            else if (nums[mid - 1] != target) return mid;
            else return findMinIndex(left, mid - 1, nums, target); // go left
        }
        else if (nums[mid] < target) return findMinIndex(mid + 1, right, nums, target); // go right
        else return findMinIndex(left, mid - 1, nums, target); // go left
    }

    private int findMaxIndex(int left, int right, int[] nums, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (mid + 1 > right) return mid;
            else if (nums[mid + 1] != target) return mid;
            else return findMaxIndex(mid + 1, right, nums, target); // go right
        }
        else if (nums[mid] < target) return findMaxIndex(mid + 1, right, nums, target); // go right
        else return findMaxIndex(left, mid - 1, nums, target); // go left
    }
}
