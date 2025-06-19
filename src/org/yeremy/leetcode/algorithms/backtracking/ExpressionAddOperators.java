package org.yeremy.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.

 

Example 1:

Input: num = "123", target = 6
Output: ["1*2*3","1+2+3"]
Explanation: Both "1*2*3" and "1+2+3" evaluate to 6.
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2","2+3*2"]
Explanation: Both "2*3+2" and "2+3*2" evaluate to 8.
Example 3:

Input: num = "3456237490", target = 9191
Output: []
Explanation: There are no expressions that can be created from "3456237490" to evaluate to 9191.
 

Constraints:

1 <= num.length <= 10
num consists of only digits.
-231 <= target <= 231 - 1
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(result, num, target, 0, 0, 0, "");
        return result;
    }
    
    /**
     * Backtracking method to find all valid expressions
     * @param result - List to store valid expressions
     * @param num - Input string of digits
     * @param target - Target value to achieve
     * @param index - Current position in the input string
     * @param eval - Current evaluation value of the expression
     * @param prevNum - Previous operand (needed for multiplication precedence)
     * @param expr - Current expression being built
     */
    private void backtrack(List<String> result, String num, int target, int index, long eval, long prevNum, String expr) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(expr);
            }
            return;
        }
        
        for (int i = index; i < num.length(); i++) {
            // Skip numbers with leading zeros
            if (i > index && num.charAt(index) == '0') break;
            
            // Parse the current number from the substring of digits
            long currNum = Long.parseLong(num.substring(index, i + 1));            
            
            if (index == 0) {
                // First number, no operator to add
                backtrack(result, num, target, i + 1, currNum, currNum, expr + currNum);
            } else {
                // Try adding '+'
                backtrack(result, num, target, i + 1, eval + currNum, currNum, expr + "+" + currNum);
                
                // Try adding '-'
                backtrack(result, num, target, i + 1, eval - currNum, -currNum, expr + "-" + currNum);
                
                // Try adding '*' (need to handle operator precedence)
                backtrack(result, num, target, i + 1, eval - prevNum + prevNum * currNum, prevNum * currNum, expr + "*" + currNum);
            }
        }
    }
}

/*
 * Time and Space Complexity Analysis
Time Complexity: O(4^n)
Explanation: For each position between digits in the input string of length n, we have at most 4 choices:

No operator (concatenate with previous digit)

Add '+'

Add '-'

Add '*'

In the worst case, we explore all possible ways to add operators between digits, leading to 4^(n-1) possible expressions.

Each expression evaluation takes O(n) time.

Therefore, the overall time complexity is O(n * 4^n).

Space Complexity: O(n)
Recursion Stack: The maximum depth of recursion is O(n) since each recursive call processes at least one digit.

Expression String: Each expression we build has at most 2n-1 characters (n digits and n-1 operators).

Result List: The space for storing results depends on the number of valid expressions, which is bounded by O(4^n).

However, this is output space and typically not counted in space complexity analysis.

Therefore, the overall space complexity is O(n) for the recursion stack and current expression being built.
 */