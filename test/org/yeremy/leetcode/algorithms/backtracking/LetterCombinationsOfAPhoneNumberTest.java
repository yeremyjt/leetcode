package org.yeremy.leetcode.algorithms.backtracking;

import org.yeremy.leetcode.algorithms.backtracking.LetterCombinationsOfAPhoneNumber;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LetterCombinationsOfAPhoneNumberTest {

    @Test
    public void letterCombinations() {
        String digits = "23";
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> combinations = letterCombinationsOfAPhoneNumber.letterCombinations(digits);
        assertEquals(9, combinations.size());
        assertTrue(combinations.contains("ad"));
        assertTrue(combinations.contains("ae"));
        assertTrue(combinations.contains("af"));
        assertTrue(combinations.contains("bd"));
        assertTrue(combinations.contains("be"));
        assertTrue(combinations.contains("bf"));
        assertTrue(combinations.contains("cd"));
        assertTrue(combinations.contains("ce"));
        assertTrue(combinations.contains("cf"));
    }
}