package org.yeremy.leetcode.algorithms.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindMinimumInRotatedSortedArrayTest {
    @Test
    public void testFindMinimumInRotatedSortedArray_1() {
        int[] nums = {4,5,6,7,0,1,2};
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int result = findMinimumInRotatedSortedArray.findMin(nums);
        assertEquals(0, result);
    }

    @Test
    public void testFindMinimumInRotatedSortedArray_2() {
        int[] nums = {3,4,5,1,2};
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int result = findMinimumInRotatedSortedArray.findMin(nums);
        assertEquals(1, result);
    }

    @Test
    public void testFindMinimumInRotatedSortedArray_3() {
        int[] nums = {1};
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int result = findMinimumInRotatedSortedArray.findMin(nums);
        assertEquals(1, result);
    }

    @Test
    public void testFindMinimumInRotatedSortedArray_4() {
        int[] nums = {2,3,1};
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        int result = findMinimumInRotatedSortedArray.findMin(nums);
        assertEquals(1, result);
    }

}