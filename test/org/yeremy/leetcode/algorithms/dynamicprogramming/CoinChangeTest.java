package org.yeremy.leetcode.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinChangeTest {

    @Test
    public void coinChange() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        int ans = coinChange.coinChange(coins, amount);
        assertEquals(3, ans);
    }
}