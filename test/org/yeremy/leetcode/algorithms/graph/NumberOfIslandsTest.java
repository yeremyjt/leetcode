package org.yeremy.leetcode.algorithms.graph;

import org.yeremy.leetcode.algorithms.graph.NumberOfIslands;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslandsTest {
    @Test
     public void testNumberOfIslands() {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int result = numberOfIslands.numIslands(grid);
        assertEquals(3, result);
    }
}