package org.yeremy.leetcode.algorithms.lessons.binarysearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int pivot = findPivot(0, nums.length - 1, nums);
        int leftResult = binarySearch(0, pivot, nums, target);
        int rightResult = binarySearch(pivot + 1, nums.length - 1, nums, target);
        return leftResult == -1 ? rightResult : leftResult;
    }

    private int findPivot(int left, int right, int[] nums) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        // There's only one element in the array
        if (mid + 1 <= nums.length - 1) {
            if (nums[mid] > nums[mid + 1]) return mid;
        }
        if (mid - 1 >= 0) {
            if (nums[mid] < nums[mid - 1]) return mid -1;
        }
        // pivot cannot exist in the right branch, go left
        if (nums[right] > nums[mid]) return findPivot(left, mid - 1, nums);
        else return findPivot(mid + 1, right, nums);
    }

    private int binarySearch(int left, int right, int[] nums, int target) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) return binarySearch(left, mid - 1, nums, target);
        else return binarySearch(mid + 1, right, nums, target);
    }
}
