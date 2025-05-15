package org.yeremy.leetcode.algorithms.string;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidWordAbbreviationTest {
    
    @Test
    public void testValidAbbreviation() {
        ValidWordAbbreviation solution = new ValidWordAbbreviation();
        assertTrue(solution.validWordAbbreviation("internationalization", "i12iz4n"));
    }
    
    @Test
    public void testInvalidAbbreviation() {
        ValidWordAbbreviation solution = new ValidWordAbbreviation();
        assertFalse(solution.validWordAbbreviation("apple", "a2e"));
    }
}
