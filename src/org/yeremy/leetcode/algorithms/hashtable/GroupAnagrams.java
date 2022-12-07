package org.yeremy.leetcode.algorithms.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once. 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

 */
public class GroupAnagrams {
    private List<List<String>> anagrams = new ArrayList<>();
    private Map<String, List<String>> map = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        // Processing anagrams.
        for (String str : strs) {
            String sortedStr = sort(str);
            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        // Returning results.
        for (String key : map.keySet()) {
            anagrams.add(map.get(key));
        }

        return anagrams;
    }

    // Sorts a sring in ascending order.
    private String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
