package org.yeremy.leetcode.algorithms;
/*

- Make a map of roman numerals to integers
- Initialize sum to the last element of the string (in integer)
- Iterate through string backwards starting i at s.length - 2
- if s[i] >= sum, then add it to sum
- else then substract it from sum
*/

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        char[] romans = s.toCharArray();

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int length = romans.length;
        int sum = romanMap.get(romans[length - 1]);

        for (int i = romans.length - 2; i >= 0; i--) {
            int left = romanMap.get(romans[i]);
            int right = romanMap.get(romans[i + 1]);
            if ( left >= right )
                sum += left;
            else
                sum -= left;
        }

        return sum;
    }
}