package org.yeremy.leetcode.algorithms;

public class FloodFill
{
    public static void main(String[] args)
    {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        for (int i = 0; i < image.length; i++)
        {
            for (int j = 0; j < image.length; j++)
            {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        floodFill(image, 1, 1, 2);
        for (int i = 0; i < image.length; i++)
        {
            for (int j = 0; j < image.length; j++)
            {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    public static void dfs(int[][] image, int r, int c, int color, int newColor)
    {
        if (image[r][c] == color)
        {
            image[r][c] = newColor;
            // up
            if (r - 1 >= 0)              dfs(image, r - 1, c, color, newColor);
            // down
            if (r + 1 < image.length)    dfs(image, r + 1, c, color, newColor);
            // left
            if (c - 1 >= 0)              dfs(image, r, c - 1, color, newColor);
            // right
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }
}
