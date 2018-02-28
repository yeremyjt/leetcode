package org.yeremy.leetcode.algorithms;

/*
Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.
 */
public class ReversePairs {
    private int[] aux;

    public void merge(int[] A, int[] aux, int start, int mid, int end)
    {
        for (int k = start; k <= end; k++)
            aux[k] = A[k];
        int i = start, j = mid + 1;
        for (int k = start; k <= end; k++)
        {
            if      (i > mid)         A[k] = aux[j++];
            else if (j > end)         A[k] = aux[i++];
            else if (aux[j] < aux[i]) A[k] = aux[j++];
            else                      A[k] = aux[i++];
        }
    }

    public int mergesortAndCount(int[]A, int[] aux, int start, int end)
    {
        if (start < end) {
            int mid = (start + end) / 2;
            int count = mergesortAndCount(A, aux, start, mid) + mergesortAndCount(A, aux, mid + 1, end);
            int j = mid + 1;
            for (int i = start; i <= mid; i++) {
                while (j <= end && (long) A[i] > (long) A[j] * 2)
                    j++;
                count += j - (mid + 1);
            }
            merge(A, aux, start, mid, end);
            return count;
        }
        else
            return 0;
    }

    public int reversePairs(int[] nums)
    {
        aux = new int[nums.length];
        return mergesortAndCount(nums, aux, 0, nums.length - 1);
    }

}
