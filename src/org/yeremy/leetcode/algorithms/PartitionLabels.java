package org.yeremy.leetcode.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> last = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < S.length(); i++) {
            last.put(S.charAt(i), i); // Recording the last position known for each character
        }

        int end = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last.get(S.charAt(i))); // Updating the end of the part
            if (i == end) { // If i == end, we have reached the end of a part
                ans.add(i - start + 1); // Adding to ans the length of the part
                start = i + 1; // Starting the next part
            }
        }

        return ans;
    }
}
