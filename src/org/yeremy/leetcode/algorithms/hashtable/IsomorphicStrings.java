package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashMap;

public class IsomorphicStrings {
    private HashMap<Character, Character> mapToT = new HashMap<>();
    private HashMap<Character, Character> mapToS = new HashMap<>();

    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (!mapToT.containsKey(s.charAt(i))) {
                mapToT.put(s.charAt(i), t.charAt(i));
            } else if (mapToT.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (!mapToS.containsKey(t.charAt(i))) {
                mapToS.put(t.charAt(i), s.charAt(i));
            } else if (mapToS.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}

