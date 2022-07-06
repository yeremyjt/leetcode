package org.yeremy.leetcode.algorithms.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimumIndexOfTwoLists {
    private HashMap<String, Integer> tempMap = new HashMap<>();
    private HashMap<String, Integer> commonChoiceMap = new HashMap<>();
    private int minSum = Integer.MAX_VALUE;

    public String[] findRestaurant(String[] list1, String[] list2) {
        for (int i = 0; i < list1.length; i++) {
            tempMap.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            if (tempMap.containsKey(list2[i])) {
                int indexSum = tempMap.get(list2[i]) + i;
                commonChoiceMap.put(list2[i], indexSum);

                if (indexSum < minSum) {
                    minSum = indexSum;
                }
            }
        }

        List<String> resultList = new ArrayList<>();

        for (String choice : commonChoiceMap.keySet()) {
            if (commonChoiceMap.get(choice) == minSum) {
                resultList.add(choice);
            }
        }

        String[] resultArray = new String[resultList.size()];
        int counter = 0;

        for (String choice : resultList) {
            resultArray[counter++] = choice;
        }

        return resultArray;
    }
}
