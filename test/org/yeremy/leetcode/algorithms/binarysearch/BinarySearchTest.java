package org.yeremy.leetcode.algorithms.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void binarySearchTest() {
        int[] nums = {-1,0,3,5,9,12};
        BinarySearch binarySearch = new BinarySearch();
        int target = 9;
        int result = binarySearch.search(nums, target);
        assertEquals(4, result);
    }

    @Test
    public void binarySearchTest_2() {
        int[] nums = {-1,0,3,5,9,12};
        BinarySearch binarySearch = new BinarySearch();
        int target = 2;
        int result = binarySearch.search(nums, target);
        assertEquals(-1, result);
    }

}