package org.yeremy.leetcode.algorithms.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FourSumTest {

    @Test
    public void fourSum() {
        int[] nums = new int[] {1000000000,1000000000,1000000000,1000000000};
        FourSum fourSum = new FourSum();
        List<List<Integer>> actual = fourSum.fourSum(nums, -294967296);
        List<List<Integer>> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }
}