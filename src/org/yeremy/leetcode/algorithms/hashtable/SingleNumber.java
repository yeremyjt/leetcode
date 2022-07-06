package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
    private Set<Integer> set = new HashSet<>();

    public int singleNumber(int[] nums) {        

        for(int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);            
            } else {
                set.add(nums[i]);                   
            }        
        }

        return set.stream().findFirst().get();
    }
}
