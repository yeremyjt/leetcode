package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashSet;
import java.util.Set;

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

 

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
 

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
 */
 
 public class JewelsAndStones {

    /* Algorithm:
     * Iterate over stone string and get unique characters and put them in a map. 
     * Iterate over jewels and increment count for each character in map found in the string.
     * Sum all the values in map and return sum. 
     */
    private final Set<Character> jewelsSet = new HashSet<>();
    
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        // Creating map.
        char[] jewelsArray = jewels.toCharArray();

        for (char c : jewelsArray) {
            jewelsSet.add(c);
        }

        char[] stonesArray = stones.toCharArray();

        for (char c : stonesArray) {
            if (jewelsSet.contains(c)) {
                count++;
            }
        }

        return count;
    }

}
