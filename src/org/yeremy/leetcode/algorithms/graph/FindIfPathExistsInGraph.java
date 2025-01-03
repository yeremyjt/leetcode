package org.yeremy.leetcode.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled
 * from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D
 * integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional
 * edge between vertex ui and vertex vi. Every vertex pair is connected by at
 * most one edge, and no vertex has an edge to itself.
 * 
 * You want to determine if there is a valid path that exists from vertex source
 * to vertex destination.
 * 
 * Given edges and the integers n, source, and destination, return true if there
 * is a valid path from source to destination, or false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * Example 2:
 * 
 * 
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0,
 * destination = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= source, destination <= n - 1
 * There are no duplicate edges.
 * There are no self edges.
 */

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // return disjointSetSolution(n, edges, source, destination);
        return dfsSolution(n, edges, source, destination);
    }

    /*
     * Algorithm: DisjoinSet
     * - Create the graph using UnionFind for all the vertices.
     * - Call isConnected and return the result
     */
    private boolean disjointSetSolution(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.connected(source, destination);
    }

    /*
     * Algorithm: DFS
     * 1. Use one bool array seen to mark all visited nodes, set seen[source] =
     * true.
     * 2. Use a hash map graph to store all edges.
     * 3. Start the search from node source. If the current node we are visiting
     * (curr_node) equals destination, return true. Otherwise, find all its neighbor
     * nodes that haven't been visited before.
     * 3.1. If there exists such a neighbor node, mark it as visited, move on to
     * this
     * node and repeat step 3.
     * 3.2. If this neighbor node can reach destination, then return true,
     * otherwise, try
     * the next neighbor.
     * 4. Return false if we finished the search without finding destination.
     */
    private boolean dfsSolution(int n, int[][] edges, int source, int destination) {
        boolean[] seen = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, val -> new ArrayList<Integer>()).add(b);
            graph.computeIfAbsent(b, val -> new ArrayList<Integer>()).add(a);
        }

        return dfs(graph, seen, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, boolean[] seen, int currNode, int destination) {
        if (currNode == destination) {
            return true;
        }

        if (!seen[currNode]) {
            seen[currNode] = true;
            for (int nextNode : graph.get(currNode)) {
                if (dfs(graph, seen, nextNode, destination)) {
                    return true;
                }
            }
        }

        return false;
    }
}
