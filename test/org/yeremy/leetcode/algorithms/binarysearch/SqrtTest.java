package org.yeremy.leetcode.algorithms.binarysearch;

import org.yeremy.leetcode.algorithms.binarysearch.Sqrt;
import org.junit.Test;

import static org.junit.Assert.*;

public class SqrtTest {
    @Test
    public void testSqrt() {
        Sqrt sqrt = new Sqrt();
        int result = sqrt.mySqrt(2147395599);
        assertEquals(46339, result);
    }
}