package org.yeremy.leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters
{
       public int lengthOfLongestSubstring(String s)
        {
            int n = s.length();
            Set<Character> set = new HashSet<>();
            int i = 0, j = 0, answer = 0;

            while (i < n && j < n)
            {
                if (!set.contains(s.charAt(j)))
                {
                    set.add(s.charAt(j++));
                    answer = Math.max(answer, j - i);
                }
                else
                {
                    set.remove(s.charAt(i++));
                }
            }

            return answer;
        }
}
