package org.yeremy.leetcode.algorithms.hashtable;

import java.util.*;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 *
 * Complexity Analysis
 *
 * Time complexity : O(N) since we go through the string of length N two times.
 * Space complexity : O(1) because English alphabet contains 26 letters.
 */

public class FirstUniqueCharacterInString {
    // Map of unique characters and sum of their occurrences.
    private final Map<Character,Integer> uniqueCharacters = new HashMap<>();

    public int firstUniqChar(String s) {

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            uniqueCharacters.put(character, uniqueCharacters.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (uniqueCharacters.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
