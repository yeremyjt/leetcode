package org.yeremy.leetcode.algorithms.graph;

/*
 You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

Example 1:

Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true
Example 2:

Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false

Constraints:

1 <= n <= 2000
0 <= edges.length <= 5000
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no self-loops or repeated edges.
 */
public class GraphValidTree {
    /* Algorithm
    - Use UnionFind algorithm.
    - Definition of a tree: For the graph to be a valid tree, it must have exactly n - 1 edges. Any less, and it can't
    possibly be fully connected. Any more, and it has to contain cycles. Additionally, if the graph is fully connected
    and contains exactly n - 1 edges, it can't possibly contain a cycle, and therefore must be a tree!
    - For each new pair, check if they are connected, if they are already connected, return false.
    - If after connecting all vertices, there is more than one set, return false.
    - Return true.
     */
    public boolean validTree(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            int A = edge[0];
            int B = edge[1];

            if (unionFind.isConnected(A, B)) {
                return false;
            }

            unionFind.union(A, B);
        }

        if (unionFind.count() > 1) {
            return false;
        }

        return true;
    }

    private class UnionFind {
        int[] root;
        int[] rank;
        int count;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
                count--;
            }
        }

        public int count() {
            return count;
        }
    }
}
