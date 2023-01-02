package org.yeremy.leetcode.algorithms.binarysearch;

import org.yeremy.leetcode.algorithms.binarysearch.SearchInRotatedSortedArray;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInRotatedSortedArrayTest {
    @Test
    public void testSearchInRotatedSortedArray() {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        assertEquals(4, result);
    }

    @Test
    public void testSearchInRotatedSortedArray_1() {
        int[] nums = {4,5,6,7,8,9,2};
        int target = 0;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        assertEquals(-1, result);
    }

    @Test
    public void testSearchInRotatedSortedArray_2() {
        int[] nums = {10,5,6,7,8,9};
        int target = 9;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        assertEquals(5, result);
    }

    @Test
    public void testSearchInRotatedSortedArray_3() {
        int[] nums = {5,1,3};
        int target = 5;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        assertEquals(0, result);
    }

    @Test
    public void testSearchInRotatedSortedArray_4() {
        int[] nums = {5,1};
        int target = 1;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        assertEquals(1, result);
    }

    @Test
    public void testSearchInRotatedSortedArray_5() {
        int[] nums = {1,2,3,4,5,6};
        int target = 2;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        assertEquals(1, result);
    }

    @Test
    public void testSearchInRotatedSortedArray_6() {
        int[] nums = {1};
        int target = 1;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        assertEquals(0, result);
    }

    @Test
    public void testSearchInRotatedSortedArray_7() {
        int[] nums = {6,7,8,1,2,3,4,5};
        int target = 6;
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int result = searchInRotatedSortedArray.search(nums, target);
        assertEquals(0, result);
    }
}