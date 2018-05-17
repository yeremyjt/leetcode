//package org.yeremy.leetcode.algorithms;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class BodiesOfWater
//{
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        Point[][] points = new Point[n][n];
//
//        for (int i = 0; i < n; i++)
//        {
//            for (int j = 0; j < n; j++)
//            {
//                points[i][j] = new Point(i, j, scanner.nextInt());
//            }
//        }
//
//        System.out.println(countBodies(points));
//    }
//
//    private static List<Integer> countBodies(Point[][] points)
//    {
//        List<Integer> bodies = new ArrayList<>();
//        for (int i = 0; i < points.length; i++)
//        {
//            for (int j = 0; j < points.length; j++)
//            {
//                if (points[i][j].val == 0 && !points[i][j].visited)
//                {
//                    bodies.add(countAdjacent(points, i, j));
//                }
//            }
//        }
//
//        Collections.sort(bodies);
//        return bodies;
//    }
//
//    private static Integer countAdjacent(Point[][] points, int x, int y)
//    {
//        if (points[x][y].visited) return 0;
//
//        // Upper point: x - 1, y
//        if (x - 1 >= 0)
//        {
//            if (points[x - 1][y].val == 0)
//            {
//                points
//                return 1 + countAdjacent(points, x - 1, y);
//            }
//        }
//
//        // Lower point: x + 1, y
//        if (x + 1 <= points.length - 1)
//        {
//            if (points[x + 1][y].val == 0) return 1 + countAdjacent(points, x + 1, y);
//        }
//
//        // Diagonal upper left point: x - 1, y - 1
//        if (x - 1 >= 0 && y - 1 >= 0)
//        {
//            if (points[x - 1][y - 1].val == 0) return 1 + countAdjacent(points, x - 1, y - 1);
//        }
//
//        // Diagonal upper right point: x - 1, y + 1
//        if (x - 1 >= 0 && y + 1 <= points.length - 1)
//        {
//            if (points[x - 1][y + 1].val == 0) return 1 + countAdjacent(points, x - 1, y + 1);
//        }
//
//        // Diagonal lower left point: x + 1, y - 1
//        if (x + 1 <= points.length - 1 && y - 1 >= 0)
//        {
//            if (points[x + 1][y - 1].val == 0) return 1 + countAdjacent(points, x + 1, y - 1);
//        }
//
//        // Diagonal lower right point: x + 1, y + 1
//        if (x + 1 <= points.length - 1 && y + 1 <= points.length - 1)
//        {
//            if (points[x + 1][y + 1].val == 0) return 1 + countAdjacent(points, x + 1, y + 1);
//        }
//
//        return 0;
//    }
//
//    private static class Point
//    {
//        int x;
//        int y;
//        int val;
//        boolean visited;
//
//        Point(int x, int y, int val)
//        {
//            this.x = x;
//            this.y = y;
//            this.val = val;
//            this.visited = false;
//        }
//    }
//}
