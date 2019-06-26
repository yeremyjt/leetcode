package org.yeremy.leetcode.algorithms.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int dollar = 1; dollar <= amount; dollar++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= dollar) {
                    dp[dollar] = Math.min(dp[dollar], dp[dollar - coins[i]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
