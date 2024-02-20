package org.yeremy.leetcode.algorithms.graph;

import java.util.HashMap;
import java.util.List;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {
        HashMap<String, Pair> gidWeight = new HashMap<>();

        // Step 1) Build the union groups.
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];

            union(gidWeight, dividend, divisor, quotient);
        }

        // Step 2) Run the evaluation, with "lazy" updates in find() function
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!gidWeight.containsKey(dividend) || !gidWeight.containsKey(divisor)) {
                results[i] = -1;
            } else {
                Pair dividendEntry = find(gidWeight, dividend);
                Pair divisorEntry = find(gidWeight, divisor);

                String dividendGid = dividendEntry.groupId;
                String divisorGid = divisorEntry.groupId;
                Double dividendWeight = dividendEntry.weight;
                Double divisorWeight = divisorEntry.weight;

                if (!dividendGid.equals(divisorGid)) {
                    results[i] = -1;
                } else {
                    results[i] = dividendWeight / divisorWeight;
                }
            }
        }

        return results;
    }

    private Pair find(HashMap<String, Pair> gidWeight, String nodeId) {
        if (!gidWeight.containsKey(nodeId)) {
            gidWeight.put(nodeId, new Pair(nodeId, 1.0));
        }

        Pair entry = gidWeight.get(nodeId);

        // Found inconsistency, trigger chain update
        if (!entry.groupId.equals(nodeId)) {
            Pair newEntry = find(gidWeight, entry.groupId);
            gidWeight.put(nodeId, new Pair(newEntry.groupId, entry.weight * newEntry.weight));
        }

        return gidWeight.get(nodeId);
    }

    private void union(HashMap<String, Pair> gidWeight, String dividend, String divisor, double quotient) {
        Pair dividendEntry = find(gidWeight, dividend);
        Pair divisorEntry = find(gidWeight, divisor);

        String dividendGid = dividendEntry.groupId;
        String divisorGid = divisorEntry.groupId;
        Double dividendWeight = dividendEntry.weight;
        Double divisorWeight = divisorEntry.weight;

        // Merge the two groups together by attaching the dividend group to the one of divisor.
        if (!dividendGid.equals(divisorGid)) {
            gidWeight.put(dividendGid, new Pair(divisorGid, divisorWeight * quotient / dividendWeight));
        }
    }
    private class Pair {
        String groupId;
        Double weight;

        public Pair (String groupId, Double weight) {
            this.groupId = groupId;
            this.weight = weight;
        }
    }
}
