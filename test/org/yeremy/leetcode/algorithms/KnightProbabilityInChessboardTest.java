package org.yeremy.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class KnightProbabilityInChessboardTest
{
    @Test
    public void testKnightProbabilityInChessboard()
    {
        KnightProbabilityInChessboard knightProbabilityInChessboard = new KnightProbabilityInChessboard();
        assertEquals(0.0625, knightProbabilityInChessboard.knightProbability(3, 2, 0, 0), 0.0001);
    }
}