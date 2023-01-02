package org.yeremy.leetcode.algorithms.hashtable;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.yeremy.leetcode.algorithms.hashtable.GroupAnagrams;
import org.junit.Test;

public class GroupAnagramsTest {

    @Test
    public void testGroupAnagrams() {
        String[] input = new String[] {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> actual = groupAnagrams.groupAnagrams(input);
        List<List<String>> expected = Arrays.asList(Arrays.asList("bat"), Arrays.asList("nat", "tan"), Arrays.asList("ate", "eat", "tea"));
        
    } 
}
