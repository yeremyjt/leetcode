package org.yeremy.leetcode.algorithms;

import java.util.HashMap;
import java.util.Map;

class LRUCache
{
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.head.prev = tail;
        this.tail.next = head;
    }

    public int get(int key)
    {
        if (map.containsKey(key))
        {
            removeNode(map.get(key));
            moveToHead(map.get(key));
            return map.get(key).value;
        }

        return -1;
    }

    public void put(int key, int value)
    {
        if (capacity == 0) return;

        Node node = new Node(key, value);
        if (map.containsKey(key)) {
            removeNode(map.get(key));
            moveToHead(node);
            map.put(key, node);
            return;
        }
        if (map.size() < capacity) {
            moveToHead(node);
            map.put(key, node);

        }
        else {
            int tailKey = removeTail();
            map.remove(tailKey);
            map.put(key, node);
            moveToHead(node);
        }
    }

    private void moveToHead(Node node)
    {
        Node prev = head.prev;
        prev.next = node;
        head.prev = node;
        node.next = head;
        node.prev = prev;
    }

    private void removeNode(Node node)
    {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private int removeTail()
    {
        Node next = tail.next;
        int tailKey = next.key;
        tail.next = next.next;
        next.next.prev = tail;
        return tailKey;
    }

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}

