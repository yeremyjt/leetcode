package org.yeremy.leetcode.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrappingRainWaterTest {
    @Test
    public void testTrappingWater() {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int rainWater = trappingRainWater.trap(input);
        assertEquals(6, rainWater);
    }
}