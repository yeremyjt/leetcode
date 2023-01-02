package org.yeremy.leetcode.algorithms.string;

import org.yeremy.leetcode.algorithms.string.RepeatedStringMatch;
import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedStringMatchTest {
    @Test
    public void testRepeatedStringMatch() {
        String A = "abcd";
        String B = "cdabcdab";
        RepeatedStringMatch repeatedStringMatch  = new RepeatedStringMatch();
        int result = repeatedStringMatch.repeatedStringMatch(A, B);
        assertEquals(3, result);
    }
}