package org.yeremy.leetcode.algorithms.backtracking;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> combinations = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            backtrack("", digits);
        }
        return combinations;
    }

    private void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            combinations.add(combination);
        }
        else {
            String digit = Character.toString(digits.charAt(0));
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = Character.toString(letters.charAt(i));
                backtrack(combination + letter, digits.substring(1));
            }
        }
    }
}
