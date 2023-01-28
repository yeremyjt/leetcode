package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    - Use a sliding window algorithm.
    - Keep track of the longest window length found so far.
    - Keep all the characters found in a hashset.
    - Increase j for each new character.
    - Once a character inside the set is found, delete element at i and increase i.
     */

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, answer = 0;

        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                answer = Math.max(answer, j - i);
            } else  {
                set.remove(s.charAt(i++));
            }
        }

        return answer;
    }
}
