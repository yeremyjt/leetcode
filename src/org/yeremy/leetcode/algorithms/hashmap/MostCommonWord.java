package org.yeremy.leetcode.algorithms.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph += ".";
        Map<String, Integer> count = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Set<String> bannedSet = new HashSet<>();
        int max = 0;
        String mostRepeated = "";

        for (String bannedWord : banned)
            bannedSet.add(bannedWord);

        for (Character letter : paragraph.toCharArray()) {
            if (Character.isLetter(letter)) {
                sb.append(Character.toLowerCase(letter));
            } else if (sb.length() > 0) {
                String word = sb.toString();
                if (!bannedSet.contains(word)) {
                    count.put(word, count.getOrDefault(word, 0) + 1);
                    if (count.get(word) > max) {
                        max = count.get(word);
                        mostRepeated = word;
                    }
                }
                sb = new StringBuilder();
            }
        }

        return mostRepeated;
    }
}