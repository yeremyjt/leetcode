package org.yeremy.leetcode.algorithms.hashtable;

import org.yeremy.leetcode.algorithms.hashtable.IsomorphicStrings;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsomorphicStringsTest {

    @Test
    public void testIsIsomorphicString() {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        boolean result = isomorphicStrings.isIsomorphic("paper", "title");
        assertTrue(result);
    }

    @Test
    public void testIsIsomorphicString_1() {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        boolean result = isomorphicStrings.isIsomorphic("badc", "baba");
        assertEquals(result, false);
    }

    @Test
    public void testIsIsomorphicString_2() {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        boolean result = isomorphicStrings.isIsomorphic("foo", "bar");
        assertEquals(result, false);
    }
}