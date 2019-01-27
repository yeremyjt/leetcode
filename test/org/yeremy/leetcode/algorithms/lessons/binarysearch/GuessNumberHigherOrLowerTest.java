package org.yeremy.leetcode.algorithms.lessons.binarysearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class GuessNumberHigherOrLowerTest {
    @Test
    public void testGuessNumber() {
        GuessNumberHigherOrLower guessNumber = new GuessNumberHigherOrLower();
        int result = guessNumber.guessNumber(10);
        assertEquals(6, result);
    }
}