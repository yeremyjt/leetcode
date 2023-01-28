package org.yeremy.leetcode.algorithms.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void testLengthOfLongestSubstring_1() {
        String input = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int actual = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testLengthOfLongestSubstring_2() {
        String input = "bbbbb";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int actual = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testLengthOfLongestSubstring_3() {
        String input = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int actual = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);
        int expected = 3;
        assertEquals(expected, actual);
    }
}