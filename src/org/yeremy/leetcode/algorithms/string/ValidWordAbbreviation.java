package org.yeremy.leetcode.algorithms.string;

/**
 * A string can be abbreviated by replacing any number of non-adjacent,
 * non-empty substrings with their lengths. The lengths should not have leading
 * zeros.
 * 
 * For example, a string such as "substitution" could be abbreviated as (but not
 * limited to):
 * 
 * "s10n" ("s ubstitutio n")
 * "sub4u4" ("sub stit u tion")
 * "12" ("substitution")
 * "su3i1u2on" ("su bst i t u ti on")
 * "substitution" (no substrings replaced)
 * The following are not valid abbreviations:
 * 
 * "s55n" ("s ubsti tutio n", the replaced substrings are adjacent)
 * "s010n" (has leading zeros)
 * "s0ubstitution" (replaces an empty substring)
 * Given a string word and an abbreviation abbr, return whether the string
 * matches the given abbreviation.
 * 
 * A substring is a contiguous non-empty sequence of characters within a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word = "internationalization", abbr = "i12iz4n"
 * Output: true
 * Explanation: The word "internationalization" can be abbreviated as "i12iz4n"
 * ("i nternational iz atio n").
 * Example 2:
 * 
 * Input: word = "apple", abbr = "a2e"
 * Output: false
 * Explanation: The word "apple" cannot be abbreviated as "a2e".
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length <= 20
 * word consists of only lowercase English letters.
 * 1 <= abbr.length <= 10
 * abbr consists of lowercase English letters and digits.
 * All the integers in abbr will fit in a 32-bit integer.
 */

public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordIndex = 0;
        int abbrIndex = 0;
        
        while (wordIndex < word.length() && abbrIndex < abbr.length()) {
            // If we encounter a digit in the abbreviation
            if (Character.isDigit(abbr.charAt(abbrIndex))) {
                // Check for leading zero
                if (abbr.charAt(abbrIndex) == '0') {
                    return false    ;
                }
                
                // Parse the number
                int num = 0;
                while (abbrIndex < abbr.length() && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }
                
                // Skip the corresponding number of characters in the word
                wordIndex += num;
                
                // If we've gone past the end of the word, the abbreviation is invalid
                if (wordIndex > word.length()) {
                    return false;
                }
            } else {
                // If we encounter a letter, it must match the corresponding letter in the word
                if (word.charAt(wordIndex) != abbr.charAt(abbrIndex)) {
                    return false;
                }
                wordIndex++;
                abbrIndex++;
            }
        }
        
        // Both indices should reach the end of their respective strings
        return wordIndex == word.length() && abbrIndex == abbr.length();
    }
}


/*
 * Time Complexity: O(n)
Where n is the length of the abbreviation string
We process each character in the abbreviation exactly once
Even though we might skip multiple characters in the word when we encounter a number, we only process each character in the abbreviation once
The inner while loop for parsing numbers doesn't increase the complexity because we can only process each digit once

Space Complexity: O(1)
We only use a constant amount of extra space:
Two integer variables (wordIndex and abbrIndex)
One integer variable (num) for parsing numbers
No additional data structures are used
The space used doesn't grow with the input size
The solution is very efficient because:
It processes the input in a single pass
It uses constant extra space
It handles all the validation rules (leading zeros, adjacent substrings, e
 */