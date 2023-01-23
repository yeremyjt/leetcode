package org.yeremy.leetcode.algorithms.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfProvincesDisjointSetTest {

    @Test
    public void findCircleNum() {
        int[][] isConnected = new int[3][3];
        isConnected[0][0] = 1;
        isConnected[0][1] = 1;
        isConnected[0][2] = 0;
        isConnected[1][0] = 1;
        isConnected[1][1] = 1;
        isConnected[1][2] = 0;
        isConnected[2][0] = 0;
        isConnected[2][1] = 0;
        isConnected[2][2] = 1;
        NumberOfProvincesDisjointSet numberOfProvinces = new NumberOfProvincesDisjointSet();
        int actual = numberOfProvinces.findCircleNum(isConnected);
        int expected = 2;
        assertEquals(expected, actual);
    }
}