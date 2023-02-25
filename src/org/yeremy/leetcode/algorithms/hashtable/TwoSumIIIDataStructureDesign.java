package org.yeremy.leetcode.algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

Implement the TwoSum class:

TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.


Example 1:

Input
["TwoSum", "add", "add", "add", "find", "find"]
[[], [1], [3], [5], [4], [7]]
Output
[null, null, null, null, true, false]

Explanation
TwoSum twoSum = new TwoSum();
twoSum.add(1);   // [] --> [1]
twoSum.add(3);   // [1] --> [1,3]
twoSum.add(5);   // [1,3] --> [1,3,5]
twoSum.find(4);  // 1 + 3 = 4, return true
twoSum.find(7);  // No two integers sum up to 7, return false


Constraints:

-105 <= number <= 105
-231 <= value <= 231 - 1
At most 104 calls will be made to add and find.

ALGORITHM:

First, we initialize a hashtable container in our data structure.

For the add(number) function, we build a frequency hashtable with the number as key and the frequency of the number as the value in the table.

For the find(value) function, we then iterate through the hashtable over the keys. For each key (number), we check if there exists a complement (value - number) in the table. If so, we could terminate the loop and return the result.

In a particular case, where the number and its complement are equal, we then need to check if there exists at least two copies of the number in the table.

COMPLEXITY ANALYSIS:

Time Complexity:

For the add(number) function: O(1), since it takes a constant time to update an entry in hashtable.

For the find(value) function: O(N), where N is the total number of unique numbers. In the worst case, we would iterate through the entire table.

Space Complexity: O(N), where N is the total number of unique numbers that we will see during the usage of the data structure.

 */
public class TwoSumIIIDataStructureDesign {

    Map<Integer, Integer> map;

    public void TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        if (map.containsKey(number)) {
            map.replace(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {

        for (Integer key : map.keySet()) {
            int complement = value - key;

            if (complement != key) {
                if (map.containsKey(complement)) {
                    return true;
                }
            } else {
                if (map.get(key) > 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
