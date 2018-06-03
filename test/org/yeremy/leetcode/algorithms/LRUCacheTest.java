package org.yeremy.leetcode.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest
{
    @Test
    public void testLRUCache_1()
    {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertEquals(1, lruCache.get(1));
        lruCache.put(3, 3);
        assertEquals(-1, lruCache.get(2));
        lruCache.put(4, 4);
        assertEquals(-1, lruCache.get(1));
        assertEquals(3, lruCache.get(3));
        assertEquals(4, lruCache.get(4));
    }

    @Test
    public void testLRUCache_2()
    {
        LRUCache lruCache = new LRUCache(2);
        assertEquals(-1, lruCache.get(2));
        lruCache.put(2, 6);
        assertEquals(-1, lruCache.get(1));
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        assertEquals(2, lruCache.get(1));
        assertEquals(6, lruCache.get(2));
    }
}