package org.yeremy.leetcode.algorithms;

import org.yeremy.leetcode.algorithms.CountAndSay;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountAndSayTest
{
    @Test
    public void testCountAndSay()
    {
        CountAndSay countAndSay = new CountAndSay();
        assertEquals("314241", countAndSay.countAndSay(6));
    }
}