package org.yeremy.leetcode.algorithms.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/*
There are n houses in a village. We want to supply water for all the houses by building wells and laying pipes.

For each house i, we can either build a well inside it directly with cost wells[i - 1] (note the -1 due to 0-indexing), 
or pipe in water from another well to it. The costs to lay pipes between houses are given by the array pipes where each 
pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j together using a pipe. Connections
 are bidirectional, and there could be multiple valid connections between the same two houses with different costs.

Return the minimum total cost to supply water to all houses.



Example 1:


Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
Output: 3
Explanation: The image shows the costs of connecting houses using pipes.
The best strategy is to build a well in the first house with cost 1 and connect the other houses to it with cost 2 so the total cost is 3.
Example 2:

Input: n = 2, wells = [1,1], pipes = [[1,2,1],[1,2,2]]
Output: 2
Explanation: We can supply water with cost two using one of the three options:
Option 1:
  - Build a well inside house 1 with cost 1.
  - Build a well inside house 2 with cost 1.
The total cost will be 2.
Option 2:
  - Build a well inside house 1 with cost 1.
  - Connect house 2 with house 1 with cost 1.
The total cost will be 2.
Option 3:
  - Build a well inside house 2 with cost 1.
  - Connect house 1 with house 2 with cost 1.
The total cost will be 2.
Note that we can connect houses 1 and 2 with cost 1 or with cost 2 but we will always choose the cheapest option.


Constraints:

2 <= n <= 104
wells.length == n
0 <= wells[i] <= 105
1 <= pipes.length <= 104
pipes[j].length == 3
1 <= house1j, house2j <= n
0 <= costj <= 105
house1j != house2j
 */

public class OptimalWaterDistributionInAVillage {

/*
  * Algorithm: 
  * - Create a virtual node that connects to all the nodes.
  * - The weight of the edge from the virtual node to each node is the cost of building a well in each node.
  * - Sort the edges in ascending order.
  * - Run a MST on the graph.
  * 
  * Algorithm for the MST using Kruskal's algorithm with UnionFind
  * - Create UnionFind data structure.
  * - Call union(house1, house2) using the sorted pipe array.
  * - If the vertices are connected, skip.
  */

  public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
    // Represent graph with list if array of edges, that will include all the
    // current edges + all nodes + the virtual node. 
    List<int[]> edges = new ArrayList<>(pipes.length + n + 1);

    // Connect virtual node with all other nodes.
    for (int i = 0; i < wells.length; i++) {
      edges.add(new int[] { 0, i + 1, wells[i]});
    }
    
    // Add the current pipes
    for (int[] pipe : pipes) {
      edges.add(pipe);
    }

    // Sorting the edges by cost.
    Collections.sort(edges, Comparator.comparingInt(a -> a[2]));

    // Run MST on the graph.
    UnionFind unionFind = new UnionFind(n + 1);
    int totalCost = 0;
    for (int[] edge : edges) {
      int A = edge[0];
      int B = edge[1];
      int cost = edge[2];

      if (unionFind.connected(A, B)) {
        continue;
      }

      unionFind.union(A, B);
      totalCost += cost;
    }

    return totalCost;      
  }

}
