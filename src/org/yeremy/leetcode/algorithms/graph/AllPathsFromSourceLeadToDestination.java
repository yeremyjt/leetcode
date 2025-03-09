package org.yeremy.leetcode.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/*
 Given the edges of a directed graph where edges[i] = [ai, bi] indicates there is an edge between nodes ai and bi, and two nodes source and destination of this graph, determine whether or not all paths starting from source eventually, end at destination, that is:

At least one path exists from the source node to the destination node
If a path exists from the source node to a node with no outgoing edges, then that node is equal to destination.
The number of possible paths from source to destination is a finite number.
Return true if and only if all roads from source lead to destination.

 

Example 1:


Input: n = 3, edges = [[0,1],[0,2]], source = 0, destination = 2
Output: false
Explanation: It is possible to reach and get stuck on both node 1 and node 2.
Example 2:


Input: n = 4, edges = [[0,1],[0,3],[1,2],[2,1]], source = 0, destination = 3
Output: false
Explanation: We have two possibilities: to end at node 3, or to loop over node 1 and node 2 indefinitely.
Example 3:


Input: n = 4, edges = [[0,1],[0,2],[1,3],[2,3]], source = 0, destination = 3
Output: true
 

Constraints:

1 <= n <= 104
0 <= edges.length <= 104
edges.length == 2
0 <= ai, bi <= n - 1
0 <= source <= n - 1
0 <= destination <= n - 1
The given graph may have self-loops and parallel edges. 


Key Insights:
- Cycles are bad (can get stuck)
- Leaf nodes must be destination
- Need to validate ALL paths
- State tracking helps detect cycles
- Once a node is VISITED, all its paths are validated

Time Complexity: O(V + E)
- V = vertices
- E = edges
- Visit each node and edge once

Space Complexity: O(V)
- States array: O(V)
- Recursion stack: O(V)

This algorithm efficiently validates that all possible paths from source will definitely reach the destination.
 */

public class AllPathsFromSourceLeadToDestination {
    enum State { UNVISITED, VISITING, VISITED }
    
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        // Build graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }
        
        // If destination has outgoing edges, return false
        if (!graph.get(destination).isEmpty()) {
            return false;
        }
        
        return dfs(graph, source, destination, new State[n]);
    }
    
    private boolean dfs(List<List<Integer>> graph, int node, int destination, State[] states) {
        // If we find a cycle, return false
        if (states[node] == State.VISITING) {
            return false;
        }
        
        // If we've already validated this path, return true
        if (states[node] == State.VISITED) {
            return true;
        }
        
        // If we reached a leaf node, it must be the destination
        if (graph.get(node).isEmpty()) {
            return node == destination;
        }
        
        states[node] = State.VISITING;
        // All paths must lead to destination
        for (int next : graph.get(node)) {
            if (!dfs(graph, next, destination, states)) {
                return false;
            }
        }
        states[node] = State.VISITED;
        
        return true;
    }
}
