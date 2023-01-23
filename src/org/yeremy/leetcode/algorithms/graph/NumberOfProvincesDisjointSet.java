package org.yeremy.leetcode.algorithms.graph;

public class NumberOfProvincesDisjointSet {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int n = isConnected.length;
        UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.getCount();
    }

    class UnionFind {
        private int[] root;
        private int[] rank;
        private int count;

        public  UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            count = size;

            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }

            return root[x] = find(root[x]);
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

        public int getCount() {
            return count;
        }
    }
}
