package org.yeremy.leetcode.algorithms.hashtable.lesson;

class MyHashSet {
    private Integer[] keys;
    private final int MAX_LENGTH = 1000000;

    public MyHashSet() {
        keys = new Integer[MAX_LENGTH];
    }

    public void add(int key) {
        keys[hash(key)] = key;
    }

    public void remove(int key) {
        keys[hash(key)] = null;
    }

    public boolean contains(int key) {
        int index = hash(key);
        return keys[index] != null && keys[index] == key;
    }

    private int hash(int key) {
        return key % MAX_LENGTH;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */