package org.yeremy.leetcode.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();

        Map<String, List<String>> map = createMap(wordList, n);
        Set<String> visited = new HashSet<>();
        Queue<Word> queue = new LinkedList<>();
        Word word = new Word(beginWord, 1);
        queue.add(word);

        while(!queue.isEmpty()) {
            Word curr = queue.poll();
            int iteration = curr.position + 1;
            String currentWord = curr.word;
            for (int i = 0; i < n; i++) {
                String newWord = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1, n);
                List<String> adjacents = map.getOrDefault(newWord, new ArrayList<>());
                for (String adjacent : adjacents) {
                    if (adjacent.equals(endWord))
                        return iteration;
                    if (!visited.contains(adjacent)) {
                        visited.add(adjacent);
                        queue.add(new Word(adjacent, iteration));
                    }
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> createMap(List<String> wordList, int n) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < n; i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, n);
                List<String> transformations = map.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                map.put(newWord, transformations);
            }
        }
        return map;
    }

    private class Word {
        String word;
        int position;

        public Word(String word, int position) {
            this.word = word;
            this.position = position;
        }
    }
}