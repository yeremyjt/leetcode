package org.yeremy.leetcode.algorithms.backtracking;

import org.yeremy.leetcode.algorithms.backtracking.GenerateParentheses;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {

    @Test
    public void generateParenthesis() {
        int n = 3;
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> result = generateParentheses.generateParenthesis(n);
        assertEquals(5, result.size());
        assertTrue(result.contains( "((()))"));
        assertTrue(result.contains("(()())"));
        assertTrue(result.contains("(())()"));
        assertTrue(result.contains("()(())"));
        assertTrue(result.contains("()()()"));
    }
}