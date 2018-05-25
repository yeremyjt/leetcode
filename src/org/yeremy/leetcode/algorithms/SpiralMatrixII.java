package org.yeremy.leetcode.algorithms;

public class SpiralMatrixII
{
    public static void main(String[] args)
    {
        int n = 4;
        int[][] matrix = generateMatrix(n);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n)
    {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = -1;
            }
        }

        int number = 1;
        int i = 1, j = -1;

        while (number <= n * n)
        {
            // Going right
            i--;
            j++;
            while (j < n)
            {
                if (matrix[i][j] == -1)
                {
                    matrix[i][j] = number++;
                    j++;
                }
                else
                {
                    j--;
                    break;
                }
            }

            // Going down
            i++;
            j--;
            while (i < n)
            {
                if (matrix[i][j] == -1)
                {
                    matrix[i][j] = number++;
                    i++;
                }
                else
                {
                    i--;
                    break;
                }
            }

            // Going left
            j--;
            i--;
            while (j >= 0)
            {
                if (matrix[i][j] == -1)
                {
                    matrix[i][j] = number++;
                    j--;
                }
                else
                {
                    j++;
                    break;
                }
            }

            // Going up
            i--;
            j++;
            while (i >= 0)
            {
                if (matrix[i][j] == -1)
                {
                    matrix[i][j] = number++;
                    i++;
                }
                else
                {
                    i--;
                    break;
                }
            }
        }

        return matrix;
    }
}
