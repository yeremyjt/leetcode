package org.yeremy.leetcode.algorithms.binarysearch;

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        return binarySearch(0, x, x);
    }

    private int binarySearch(int left, int right, int target) {
        if (left > right) return right;
        int mid = left + (right - left) /2;
        if (mid == target/mid) return mid;
        else if (mid > target/mid) return binarySearch(left, mid - 1, target);
        else return binarySearch(mid + 1, right, target);
    }
}
