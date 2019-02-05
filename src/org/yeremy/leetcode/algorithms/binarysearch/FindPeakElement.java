package org.yeremy.leetcode.algorithms.binarysearch;

/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5
Explanation: Your function can return either index number 1 where the peak element is 2,
             or index number 5 where the peak element is 6.
 */
public class FindPeakElement
{
    public int findPeakElement(int[] nums) {
        return binarySearch(0, nums.length - 1, nums);
    }

    private int binarySearch(int left, int right, int[] nums) {
        if (left == right) return left;
        int mid = left + (right - left) / 2;
        // somewhere in the middle
        if (mid - 1 >= 0 && mid + 1 <= right) {
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) return mid;
                // slope to the right
            else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1])
                return binarySearch(mid + 1, right, nums);
            else return binarySearch(left, mid - 1, nums);
        }
        // only two elements
        else if (nums[mid] > nums[mid + 1]) return mid;
        else return mid + 1;
    }
}
