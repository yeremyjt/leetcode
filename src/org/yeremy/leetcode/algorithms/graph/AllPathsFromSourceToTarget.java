package org.yeremy.leetcode.algorithms.graph;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 */
public class AllPathsFromSourceToTarget {    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int target = graph.length - 1;
        path.addLast(0); // Add starting node
        dfs(graph, 0, target, path, paths);
        return paths;
    }

    private void dfs(int[][] graph, int node, int target, LinkedList<Integer> path, List<List<Integer>> paths) {
        if (node == target) {
            paths.add(new ArrayList<>(path)); // Make a copy of the path
            return;
        }
        
        for (int nextNode : graph[node]) {
            path.addLast(nextNode);
            dfs(graph, nextNode, target, path, paths);
            path.removeLast(); // Backtrack
        }
    }
}
