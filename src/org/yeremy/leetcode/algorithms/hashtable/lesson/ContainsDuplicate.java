package org.yeremy.leetcode.algorithms.hashtable.lesson;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    private Set<Integer> set = new HashSet<>(); 

    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }
}
