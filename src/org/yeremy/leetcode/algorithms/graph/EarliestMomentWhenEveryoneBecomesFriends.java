package org.yeremy.leetcode.algorithms.graph;

import java.util.Arrays;
import java.util.Comparator;

/*
There are n people in a social group labeled from 0 to n - 1. You are given an array logs where logs[i] = [timestampi, xi, yi] indicates that xi and yi will be friends at the time timestampi.

Friendship is symmetric. That means if a is friends with b, then b is friends with a. Also, person a is acquainted with a person b if a is friends with b, or a is a friend of someone acquainted with b.

Return the earliest time for which every person became acquainted with every other person. If there is no such earliest time, return -1.

Example 1:

Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], n = 6
Output: 20190301
Explanation:
The first event occurs at timestamp = 20190101, and after 0 and 1 become friends, we have the following friendship groups [0,1], [2], [3], [4], [5].
The second event occurs at timestamp = 20190104, and after 3 and 4 become friends, we have the following friendship groups [0,1], [2], [3,4], [5].
The third event occurs at timestamp = 20190107, and after 2 and 3 become friends, we have the following friendship groups [0,1], [2,3,4], [5].
The fourth event occurs at timestamp = 20190211, and after 1 and 5 become friends, we have the following friendship groups [0,1,5], [2,3,4].
The fifth event occurs at timestamp = 20190224, and as 2 and 4 are already friends, nothing happens.
The sixth event occurs at timestamp = 20190301, and after 0 and 3 become friends, we all become friends.
Example 2:

Input: logs = [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]], n = 4
Output: 3
Explanation: At timestamp = 3, all the persons (i.e., 0, 1, 2, and 3) become friends.


Constraints:

2 <= n <= 100
1 <= logs.length <= 104
logs[i].length == 3
0 <= timestampi <= 109
0 <= xi, yi <= n - 1
xi != yi
All the values timestampi are unique.
All the pairs (xi, yi) occur at most one time in the input.

/*
    Algorithm:
    - Sort the array by timestamp.
    - Use UnionFind data structure to add each new friendship.
    - When all elements are connected return the timestamp.

    Let N be the number of people and M be the number of logs.

    Time comlexity: O(N + MLogM + Ma(N))
    - O(N) to create UnionFind data structure.
    - O(MLogM) to sort the logs in order of timestemp using quick sort.
    - Ma(N) the amortized time complexity to invoke union(a, b) for each log

    Space complexity: O(N LogM)
    - O(N) Space complexity of UnionFinddata structure of O(N)
    - O(LogM) Space complexity of Arrays.sort which uses variang of quicksort.
 */

public class EarliestMomentWhenEveryoneBecomesFriends {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(array -> array[0]));

        UnionFind unionFind = new UnionFind(n);

        for (int[] newFriendship : logs) {
            unionFind.union(newFriendship[1], newFriendship[2]);
            if (unionFind.count == 1) {
                return newFriendship[0];
            }
        }

        return -1;
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

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
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
