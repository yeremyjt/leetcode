package org.yeremy.leetcode.algorithms.array;

import org.yeremy.leetcode.algorithms.array.FruitIntoBaskets;
import org.junit.Test;

import static org.junit.Assert.*;

public class FruitIntoBasketsTest {
    @Test
    public void testFruitIntoBaskets_1() {
        int[] input = {1,2,1};
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int actual = fruitIntoBaskets.totalFruit(input);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testFruitIntoBaskets_2() {
        int[] input = {0,1,2,2};
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int actual = fruitIntoBaskets.totalFruit(input);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testFruitIntoBaskets_3() {
        int[] input = {1,2,3,2,2};
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int actual = fruitIntoBaskets.totalFruit(input);
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void testFruitIntoBaskets_4() {
        int[] input = {3,3,3,1,2,1,1,2,3,3,4};
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int actual = fruitIntoBaskets.totalFruit(input);
        int expected = 5;
        assertEquals(expected, actual);
    }
}