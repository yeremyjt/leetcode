package org.yeremy.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

/*
I = 1
V = 5 CANNOT BE REPEATED
X = 10
L = 50 CANNOT BE REPEATED
C = 100
D = 500 CANNOT BE REPEATED
M = 1000

letters cannot be repeated more than 3 times, except for V, L, D

Numbers that decrease from left to right are added
A smaller number at the left of a larger number is a substraction

MMMCMXCIX

- Convert the string to char array
- Create a map of roman letters to numbers
- Read from left to right
- Initialize variable sum to 0
- Initialize curr and prev to 0
- Intialize left to 0 and right to 1
- If curr > prev; sum -= (curr + prev); sum += (curr - prev) // backtracks and then recalculates
*/
public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MMMCMXCIX"));
    }
    public static int romanToInt(String s) {
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
        int sum = 0;
        int index = 0;
        int curr = 0;
        int prev = 0;

        while (index < length) {
            curr = romanMap.get(romans[index++]);
            sum += curr;

            if (curr > prev && prev != 0) {
                sum -= (curr + prev);
                sum += (curr - prev);
            }

            prev = curr;
        }

        return sum;
    }
}
