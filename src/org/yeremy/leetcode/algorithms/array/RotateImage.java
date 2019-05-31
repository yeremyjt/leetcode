package org.yeremy.leetcode.algorithms.array;

class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp1, temp2, row, col;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // right
                row = j;
                col = n - i - 1;
                temp1 = matrix[row][col];
                matrix[row][col] = matrix[i][j];

                // down
                row = n - i - 1;
                col = n - j - 1;
                temp2 = matrix[row][col];
                matrix[row][col] = temp1;

                // left
                row = n - j - 1;
                col = i;
                temp1 = matrix[row][col];
                matrix[row][col] = temp2;

                // up
                row = i;
                col = j;
                matrix[row][col] = temp1;
            }
        }
    }
}