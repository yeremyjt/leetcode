package org.yeremy.leetcode.algorithms.binarysearch;

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
