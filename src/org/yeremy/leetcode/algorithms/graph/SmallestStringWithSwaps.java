package org.yeremy.leetcode.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        UnionFind uf = new UnionFind(s.length());

        // Iterating over the edges
        for (List<Integer> edge : pairs) {
            int source = edge.get(0);
            int destination = edge.get(1);

            uf.union(source, destination);
        }

        Map<Integer, List<Integer>> rootToComponent = new HashMap<>();

        // Group the vertices that are in the same component
        for (int vertex = 0; vertex < s.length(); vertex++) {
            int root = uf.find(vertex);
            rootToComponent.putIfAbsent(root, new ArrayList<>());
            rootToComponent.get(root).add(vertex);
        }

        // String to store the asnwer
        char[] smallestString = new char[s.length()];

        // Iterate over the components
        for (List<Integer> indices : rootToComponent.values()) {
            // Sort the characters in each group
            List<Character> characters = new ArrayList<>();
            for (int index : indices) {
                characters.add(s.charAt(index));
            }
            
            Collections.sort(characters);

            // Store the sorted characters
            for (int index = 0; index < indices.size(); index++) {
                smallestString[indices.get(index)] = characters.get(index);
            }            
        }
        
        return new String(smallestString);

    }

}