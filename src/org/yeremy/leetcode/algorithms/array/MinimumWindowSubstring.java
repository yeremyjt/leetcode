package org.yeremy.leetcode.algorithms.array;

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t){
        Map<Character, Integer> map = fillMap(t);
        Map<Character, Integer> found = new HashMap<>();
        int tLen = t.length();
        int i = 0;
        int j = 0;
        int minLen = Integer.MAX_VALUE;
        String minSubstring = "";

        int required = map.size();
        int formed = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                int count = found.getOrDefault(s.charAt(j), 0);
                found.put(s.charAt(j), count + 1);

                if (map.get(s.charAt(j)).intValue() == found.get(s.charAt(j)).intValue())
                    formed++;
            }

            j++;

            while (i < j && formed == required) {
                int tempLen = j - i;

                if (tempLen < minLen) {
                    minLen = tempLen;
                    minSubstring = s.substring(i, j);
                    if (minLen == tLen)
                        return minSubstring;
                }

                if (map.containsKey(s.charAt(i))) {
                    found.put(s.charAt(i), found.get(s.charAt(i)) - 1);

                    if (found.get(s.charAt(i))< map.get(s.charAt(i)))
                        formed--;
                }
                i++;
            }
        }
        return minSubstring;
    }

    private Map<Character, Integer> fillMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : t.toCharArray()) {
            int count = map.getOrDefault(character, 0);
            map.put(character, count + 1);
        }

        return map;
    }
}
