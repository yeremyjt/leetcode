package org.yeremy.leetcode.algorithms.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerWithMostWaterTest {

    @Test
    public void maxArea_1() {
        int[] input = {1,8, 6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int ans = containerWithMostWater.maxArea(input);
        assertEquals(49, ans);
    }

    @Test
    public void maxArea_2() {
        int[] input = {1,3,2,5,25,24,5};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        int ans = containerWithMostWater.maxArea(input);
        assertEquals(24, ans);
    }
}