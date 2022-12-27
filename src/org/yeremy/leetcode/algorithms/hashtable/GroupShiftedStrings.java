package org.yeremy.leetcode.algorithms.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
We can shift a string by shifting each of its letters to its successive letter.

For example, "abc" can be shifted to be "bcd".
We can keep shifting the string to form a sequence.

For example, we can keep shifting "abc" to form the sequence: "abc" -> "bcd" -> ... -> "xyz".
Given an array of strings strings, group all strings[i] that belong to the same shifting sequence. You may return the answer in any order.

 

Example 1:

Input: strings = ["abc","bcd","acef","xyz","az","ba","a","z"]
Output: [["acef"],["a","z"],["abc","bcd","xyz"],["az","ba"]]
Example 2:

Input: strings = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strings.length <= 200
1 <= strings[i].length <= 50
strings[i] consists of lowercase English letters.
 */

public class GroupShiftedStrings {

    private Map<String, List<String>> map = new HashMap<>();
    private List<List<String>> shiftedStrings = new ArrayList<>();
    
    public List<List<String>> groupStrings(String[] strings) {
        
        // Iterate over list of strings and group them in lists.
        for (String str : strings) {
            String hash = getHash(str);

            if (map.get(hash) == null) {
                map.put(hash, new ArrayList<>());
            }

            map.get(hash).add(str);
        }

        // Create output list.
        for (List<String> groups : map.values()) {
            shiftedStrings.add(groups);
        }

        return shiftedStrings;
    }

    // Creates hash for String based on difference of characters. 
    private String getHash(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < chars.length; i++) {
            sb.append((char) (chars[i] - chars[i - 1] + 26) % 26 + 'a');
        }

        return sb.toString();
    }

}
