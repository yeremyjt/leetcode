package org.yeremy.leetcode.algorithms.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestAbsoluteFilePathTest {

    @Test
    public void testLongestAbsoluteFilePath_1() {
        LongestAbsoluteFilePath longestAbsoluteFilePath = new LongestAbsoluteFilePath();
        int longestPath = longestAbsoluteFilePath.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        assertEquals(20, longestPath);
    }

    @Test
    public void testLongestAbsoluteFilePath_2() {
        LongestAbsoluteFilePath longestAbsoluteFilePath = new LongestAbsoluteFilePath();
        int longestPath = longestAbsoluteFilePath.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        assertEquals(32, longestPath);
    }

    @Test
    public void testLongestAbsoluteFilePath_3() {
        LongestAbsoluteFilePath longestAbsoluteFilePath = new LongestAbsoluteFilePath();
        int longestPath = longestAbsoluteFilePath.lengthLongestPath("dir\n    file.ext");
        assertEquals(12, longestPath);
    }
}