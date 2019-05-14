package org.yeremy.leetcode.algorithms.string;

import org.junit.Test;
import org.yeremy.leetcode.algorithms.string.MostCommonWord;

import static org.junit.Assert.*;

public class MostCommonWordTest {

    @Test
    public void mostCommonWord() {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        MostCommonWord mostCommonWord = new MostCommonWord();
        String result = mostCommonWord.mostCommonWord(paragraph, banned);
        assertEquals("b", result);
    }

    @Test
    public void mostCommonWord_1() {
        String paragraph = "Bob";
        String[] banned = {""};
        MostCommonWord mostCommonWord = new MostCommonWord();
        String result = mostCommonWord.mostCommonWord(paragraph, banned);
        assertEquals("bob", result);
    }
}