package org.yeremy.leetcode.algorithms.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class JewelsAndStonesTest {

    @Test
    public void numJewelsInStones() {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        int actual = jewelsAndStones.numJewelsInStones("aA", "aAAbbbb");
        int expected = 3;
        assertEquals(expected, actual);
    }
}