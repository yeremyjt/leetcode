package org.yeremy.leetcode.algorithms.backtracking;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ExpressionAddOperatorsTest {
    
    @Test
    public void testExpressionAddOperators_1() {
        String num = "123";
        int target = 6;

        ExpressionAddOperators expressionAddOperators = new ExpressionAddOperators();
        List<String> solution = expressionAddOperators.addOperators(num, target);
        
        List<String> expected = List.of("1+2+3", "1*2*3");
        assertEquals(expected, solution);
    }

    @Test
    public void testExpressionAddOperators_2() {
        String num = "232";
        int target = 8;

        ExpressionAddOperators expressionAddOperators = new ExpressionAddOperators();
        List<String> solution = expressionAddOperators.addOperators(num, target);
        
        List<String> expected = List.of("2+3*2", "2*3+2");
        assertEquals(expected, solution);
    }

    @Test
    public void testExpressionAddOperators_3() {
        String num = "3456237490";
        int target = 9191;

        ExpressionAddOperators expressionAddOperators = new ExpressionAddOperators();
        List<String> solution = expressionAddOperators.addOperators(num, target);
                
        assertEquals(new ArrayList<>(), solution);
    }
    
    
}
