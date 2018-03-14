package org.yeremy.leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    public static void main (String[] args) {
        letterCombinations("234");
    }

    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i < digits.length();i++) {
            System.out.println("Calculating for digit " + i);
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                    System.out.println(t + s);
                }
            }
        }
        return ans;
    }
}
