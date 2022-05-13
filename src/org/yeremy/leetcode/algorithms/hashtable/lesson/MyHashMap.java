package org.yeremy.leetcode.algorithms.hashtable.lesson;

class MyHashMap {
    private Integer[] keys;
    private Integer[] values;
    private final int MAX_LENGTH = 1000000;

    public MyHashMap() {
        keys = new Integer[MAX_LENGTH];
        values = new Integer[MAX_LENGTH];
    }

    public void put(int key, int value) {
        int index = hash(key);
        keys[index] = key;
        values[index] = value;
    }

    public int get(int key) {
        int index = hash(key);
        if (keys[index] != null && keys[index] == key){
            return values[index];
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        keys[index] = null;
        values[index] = null;
    }

    private int hash(int key) {
        return key % MAX_LENGTH;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */