package org.yeremy.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> ageMap = new HashMap<>();
    int capacity;
    int valueCounter;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.valueCounter = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ageMap.put(key, valueCounter++);
            return map.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.size() < capacity) {
            map.put(key, value);
            ageMap.put(key, valueCounter++);
        }
        else {
            deleteOldestKey();
            map.put(key, value);
            ageMap.put(key, valueCounter++);
        }
    }

    private void deleteOldestKey() {
        int oldestValue = Integer.MAX_VALUE;
        int oldestKey = 0;

        for (Integer key : ageMap.keySet()) {
            if (ageMap.get(key) < oldestValue) {
                oldestValue = ageMap.get(key);
                oldestKey = key;
            }
        }

        map.remove(oldestKey);
        ageMap.remove(oldestKey);
    }
}
