package org.yeremy.leetcode.algorithms.dynamicprogramming;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int[] maxLeftArray = new int[height.length];
        int[] maxRightArray = new int[height.length];
        int maxLeft = 0;
        int maxRight = 0;
        int rainWater = 0;

        // Filling maxLeftArray
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxLeft) maxLeft = height[i];
            maxLeftArray[i] = maxLeft;
        }

        // Filling maxRightArray
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > maxRight) maxRight = height[i];
            maxRightArray[i] = maxRight;
        }

        // Calculating rainWater
        for (int i = 0; i < height.length; i++) {
            rainWater += (Math.min(maxLeftArray[i], maxRightArray[i]) - height[i]);
        }

        return rainWater;
    }
}
