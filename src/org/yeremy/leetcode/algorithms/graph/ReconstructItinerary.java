package org.yeremy.leetcode.algorithms.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.

 

Example 1:


Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
Output: ["JFK","MUC","LHR","SFO","SJC"]
Example 2:


Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 

Constraints:

1 <= tickets.length <= 300
tickets[i].length == 2
fromi.length == 3
toi.length == 3
fromi and toi consist of uppercase English letters.
fromi != toi
 */

public class ReconstructItinerary {
    // Use PriorityQueue for lexicographical ordering of destinations
    private Map<String, PriorityQueue<String>> graph = new HashMap<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        // Build the graph
        for (List<String> ticket : tickets) {
            // computeIfAbsent creates a new PQ if the key doesn't exist
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                 .add(ticket.get(1));
        }
        
        // Use LinkedList for O(1) addFirst operation
        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", route);
        return route;
    }
    
    private void dfs(String airport, LinkedList<String> route) {
        // Get PQ of destinations from current airport
        PriorityQueue<String> destinations = graph.get(airport);
        
        // Keep visiting next lexicographically smallest destination
        while (destinations != null && !destinations.isEmpty()) {
            // Remove the destination as we use this ticket
            String nextDest = destinations.poll();
            dfs(nextDest, route);
        }
        
        // After exploring all destinations from this airport,
        // add it to the beginning of our route
        route.addFirst(airport);
    }
}
