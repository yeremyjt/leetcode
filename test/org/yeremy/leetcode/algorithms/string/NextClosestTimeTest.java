package org.yeremy.leetcode.algorithms.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextClosestTimeTest {

    @Test
    public void nextClosestTime() {
        String time = "19:34";
        NextClosestTime nextClosestTime = new NextClosestTime();
        String ans = nextClosestTime.nextClosestTime(time);
        assertEquals("19:39", ans);
    }
}