package org.yeremy.leetcode.algorithms.binarysearch;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int pivot = findPivot(0, nums.length - 1, nums);
        if (pivot == -1) return nums[0];
        return Math.min(nums[0], nums[pivot + 1]);
    }

    private int findPivot(int left, int right, int[] nums) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (mid + 1 <= nums.length - 1) {
            if (nums[mid] > nums[mid + 1]) return mid;
        }
        if (mid - 1 >= 0) {
            if (nums[mid] < nums[mid - 1]) return mid - 1;
        }
        // pivot cannot exist in the right branch, go left
        if (nums[right] > nums[mid]) return findPivot(left, mid - 1, nums);
        else return findPivot(mid + 1, right, nums);
    }
}
