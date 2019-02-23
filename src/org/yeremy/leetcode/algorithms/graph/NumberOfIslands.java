package org.yeremy.leetcode.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid == null) return 0;
        int islandCounter = 0;
        int rows = grid.length;
        int columns = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
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

    private void bfs(int i , int j, char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        Cell root = new Cell(i, j);
        Queue<Cell> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Cell curr = queue.poll();
            if (curr.i < 0 || curr.j < 0 || curr.i >= rows || curr.j >= columns || grid[curr.i][curr.j] == '0') continue;

            grid[curr.i][curr.j] = '0';
            queue.add(new Cell(curr.i - 1, curr.j)); // up
            queue.add(new Cell(curr.i + 1, curr.j)); // down
            queue.add(new Cell(curr.i, curr.j + 1)); // right
            queue.add(new Cell(curr.i, curr.j - 1)); // left
        }
    }

    private class Cell {
        public int i;
        public int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
