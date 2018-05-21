package org.yeremy.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BodiesOfWater
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[][] points = new Point[n][n];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                points[i][j] = new Point(i, j, scanner.nextInt());
            }
        }

        System.out.println(countBodies(points));
    }

    private static List<Integer> countBodies(Point[][] points)
    {
        List<Integer> bodies = new ArrayList<>();
        for (int i = 0; i < points.length; i++)
        {
            for (int j = 0; j < points.length; j++)
            {
                if (points[i][j].val == 0 && !points[i][j].visited)
                {
                    bodies.add(countAdjacent(points, i, j));
                }
            }
        }

        Collections.sort(bodies);
        return bodies;
    }

    private static Integer countAdjacent(Point[][] points, int x, int y)
    {
        if (x < 0 || x >= points.length || y < 0 || y >= points.length ||
            points[x][y].visited || points[x][y].val != 0) return 0;

            points[x][y].visited = true;

            return 1 +
                    countAdjacent(points, x - 1, y) + // up
                    countAdjacent(points, x + 1, y) + // down
                    countAdjacent(points, x, y - 1) + // left
                    countAdjacent(points, x, y + 1) + // right
                    countAdjacent(points, x - 1, y - 1) + // upper left diagonal
                    countAdjacent(points, x - 1, y + 1) + // upper right diagonal
                    countAdjacent(points, x + 1, y - 1) + // lower left diagonal
                    countAdjacent(points, x + 1, y + 1); // lower right diagonal
    }

    private static class Point
    {
        int x;
        int y;
        int val;
        boolean visited;

        Point(int x, int y, int val)
        {
            this.x = x;
            this.y = y;
            this.val = val;
            this.visited = false;
        }
    }
}
