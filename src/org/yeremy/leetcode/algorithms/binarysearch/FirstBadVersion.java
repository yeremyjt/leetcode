package org.yeremy.leetcode.algorithms.binarysearch;

/*
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example:

Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version.
 */
public class FirstBadVersion
{
    public int firstBadVersion(int n) {
        return binarySearch(0, n);
    }

    private int binarySearch(int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) return binarySearch(left, mid - 1);
        else if (isBadVersion(mid + 1)) return mid + 1;
        else return binarySearch(mid + 1, right);
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}
