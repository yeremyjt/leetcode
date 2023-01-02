package org.yeremy.leetcode.algorithms.dynamicprogramming;

import org.yeremy.leetcode.algorithms.dynamicprogramming.LongestPalindromicSubstring;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPalindromicSubstringTest {

    @Test
    public void longestPalindrome() {
        String input = "babad";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String ans = longestPalindromicSubstring.longestPalindrome(input);
        assertEquals("aba", ans);
    }

    @Test
    public void longestPalindrome_1() {
        String input = "abcba";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String ans = longestPalindromicSubstring.longestPalindrome(input);
        assertEquals("abcba", ans);
    }

    @Test
    public void longestPalindrome_2() {
        String input = "cbbd";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String ans = longestPalindromicSubstring.longestPalindrome(input);
        assertEquals("bb", ans);
    }

    @Test
    public void longestPalindrome_3() {
        String input = "ac";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String ans = longestPalindromicSubstring.longestPalindrome(input);
        assertEquals("c", ans);
    }

    @Test
    public void longestPalindrome_4() {
        String input = "aaaa";
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String ans = longestPalindromicSubstring.longestPalindrome(input);
        assertEquals("aaaa", ans);
    }
}