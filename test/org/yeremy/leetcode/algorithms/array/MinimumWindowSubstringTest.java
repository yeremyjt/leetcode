package org.yeremy.leetcode.algorithms.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumWindowSubstringTest {
    @Test
    public void testMinimumWindowSubstring() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String result = minimumWindowSubstring.minWindow(s, t);
        assertEquals("BANC", result);
    }

    @Test
    public void testMinimumWindowSubstring_1() {
        String s = "aaabdabcefaecbef";
        String t = "abc";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String result = minimumWindowSubstring.minWindow(s, t);
        assertEquals("abc", result);
    }

    @Test
    public void testMinimumWindowSubstring_2() {
        String s = "aa";
        String t = "aa";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String result = minimumWindowSubstring.minWindow(s, t);
        assertEquals("aa", result);
    }

    @Test
    public void testMinimumWindowSubstring_3() {
        String s = "acbbaca";
        String t = "aba";
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        String result = minimumWindowSubstring.minWindow(s, t);
        assertEquals("baca", result);
    }
}