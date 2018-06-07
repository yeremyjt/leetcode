package org.yeremy.leetcode.algorithms;

import java.util.Arrays;

public class KnightProbabilityInChessboard
{
    private int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public double knightProbability(int N, int K, int r, int c) {
        int[][] validCount = new int[N][N];
        for (int[] row : validCount) {
             Arrays.fill(row, 1);
        }

        for(int k = 0; k < K; k++) { // Iterate through all possible moves
            int[][] currentValidCount = new int[N][N];
            for (int i = 0; i < N; i++) {  // Filling out the board with count of valid moves per cell
                for (int j = 0; j < N; j++) {
                     for (int[] move: moves) {
                         int row = move[0];
                         int col = move[1];
                         if (isValid(row, col, N))
                             currentValidCount[i][j] += validCount[row][col];
                     }
                }
            }
            validCount = currentValidCount;
        }

        return validCount[r][c] / Math.pow(8, K);
    }

    private boolean isValid(int row, int col, int N) {
        return (row >= 0 && row < N && col >= 0 && col < N);
    }
}
