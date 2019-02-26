package org.yeremy.leetcode.algorithms.array;

import java.util.HashSet;
import java.util.Set;

public class FruitIntoBaskets
{
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int max = 1;
        int count = 1;
        int i = 0;
        int j = 1;
        set.add(tree[i]);

        while (j < tree.length) {
            if (set.contains(tree[j])) {
                count++;
                j++;
            }
            else if (set.size() < 2) {
                set.add(tree[j]);
                count++;
                j++;
            }
            else {
                if (count > max)
                    max = count;
                i = findFirstIndex(j - 1, tree);
                count = j - i + 1;
                set.clear();
                set.add(tree[i]);
                set.add(tree[j]);
                j++;
            }
        }

        if (count > max) return count;
        else return max;
    }


    private int findFirstIndex(int index, int[] array) {
        int curr = index;
        while (array[curr] == array[index]) {
            curr--;
        }

        return curr + 1;
    }
}
