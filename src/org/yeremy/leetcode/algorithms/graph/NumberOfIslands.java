package org.yeremy.leetcode.algorithms.graph;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        int islandCounter = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islandCounter++;
                }
            }
        }

        return islandCounter;
    }

    private void dfs(int i, int j, char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        if (i < 0 || j < 0 || i >= rows || j >= columns || grid[i][j] == '0')
            return;

        grid[i][j] = '0';
        dfs(i - 1, j, grid); // up
        dfs(i + 1, j, grid); // down
        dfs(i, j + 1, grid); // right
        dfs(i, j - 1, grid); // left
    }
}
