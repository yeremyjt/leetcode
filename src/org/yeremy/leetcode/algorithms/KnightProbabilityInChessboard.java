package org.yeremy.leetcode.algorithms;

import java.util.Arrays;

public class KnightProbabilityInChessboard
{
    private int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public double knightProbability(int N, int K, int r, int c) {
        double[][] validCount = new double[N][N];
        for (double[] row : validCount) {
            Arrays.fill(row, 1);
        }

        for(int k = 0; k < K; k++) { // Iterate through K moves
            double[][] currentValidCount = new double[N][N];
            for (int i = 0; i < N; i++) {  // Filling out the board with count of valid moves per cell
                for (int j = 0; j < N; j++) {
                    for (int[] move: moves) { // Going through every possible move
                        int row = i + move[0];
                        int col = j + move[1];
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
}
