package org.yeremy.leetcode.algorithms.graph;


import org.yeremy.leetcode.algorithms.graph.WordLadder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordLadderTest {

    @Test
    public void ladderLength() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        WordLadder wordLadder = new WordLadder();
        int ans = wordLadder.ladderLength(beginWord, endWord, wordList);
        assertEquals( 5, ans);
    }
}