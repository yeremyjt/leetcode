package org.yeremy.leetcode.algorithms.hashtable;

import org.yeremy.leetcode.algorithms.hashtable.FirstUniqueCharacterInString;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqueCharacterInStringTest {

    @Test
    public void firstUniqCharTest() {
        FirstUniqueCharacterInString firstUniqueCharacterInString = new FirstUniqueCharacterInString();
        int result = firstUniqueCharacterInString.firstUniqChar("leetcode");
        assertEquals(result, 0);
    }
}