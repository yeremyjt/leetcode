package org.yeremy.leetcode.algorithms.dynamicprogramming;

public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeftArray = new int[n];
        int[] maxRightArray = new int[n];
        int maxLeft = 0, maxRight = 0, rainWater = 0;

        // Filling maxLeftArray
        for (int i = 0; i < n; i++) {
            if (height[i] > maxLeft) maxLeft = height[i];
            maxLeftArray[i] = maxLeft;
        }

        // Filling maxRightArray
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] > maxRight) maxRight = height[i];
            maxRightArray[i] = maxRight;
        }

        // Calculating rainWater
        for (int i = 0; i < n; i++) {
            rainWater += (Math.min(maxLeftArray[i], maxRightArray[i]) - height[i]);
        }

        return rainWater;
    }
}
