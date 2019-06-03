package org.yeremy.leetcode.algorithms.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MissingNumbers {
    public int missingNumbers(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        for (int number = 0; number <= n; number++) {
            if (!set.contains(number))
                return number;
        }

        return -1;
    }
}
