package org.yeremy.leetcode.algorithms.dynamicprogramming;

import org.yeremy.leetcode.algorithms.dynamicprogramming.MaximumSubarray;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {
    @Test
    public void testMaximumSubarray() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int actual = maximumSubarray.maxSubArray(nums);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumSubarray_1() {
        int[] nums = {1};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int actual = maximumSubarray.maxSubArray(nums);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumSubarray_2() {
        int[] nums = {8,-19,5,-4,20};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int actual = maximumSubarray.maxSubArray(nums);
        int expected = 21;
        assertEquals(expected, actual);
    }

}