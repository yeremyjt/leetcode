package org.yeremy.leetcode.algorithms.stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {
    /** Algorithm:
    - First pass (forward)
      - Use stack to store indices of open parenthesis
      - Use StringBuilder to store the result. 
      - If valid closing parenthesis, pop the stack. 
      - If invalid closing parenthesis found, mark with *
    - Second pass (reverse)
        - Mark all remaining indices of open parenthesis with *
        - Create a new StringBuilder and copy the contents of result without the *.
     */
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder(s);
        
        // First pass: handle invalid closing parentheses
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Matched with an opening parenthesis
                } else {
                    result.setCharAt(i, '*'); // Mark invalid closing parenthesis
                }
            }
        }
        
        // Second pass: handle unmatched opening parentheses
        while (!stack.isEmpty()) {
            result.setCharAt(stack.pop(), '*'); // Mark invalid opening parenthesis
        }
        
        // Remove all marked characters
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '*') {
                finalResult.append(result.charAt(i));
            }
        }

        return finalResult.toString();
    }
}