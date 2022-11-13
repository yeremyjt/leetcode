package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashMap;

public class LoggerRateLimiter {
    private HashMap<String, Integer> map = new HashMap<>();

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (timestamp >= map.get(message) + 10) {
                map.put(message, timestamp);
                return true;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }

        return false;
    }
}

/**
 Time Complexity: O(1). The lookup and update of the hashtable takes a constant time.
Space Complexity: O(M) where MMM is the size of all incoming messages. Over the time, the hashtable would have an entry for each unique message that has appeared.
 */