package com.chrzanop.coding.algoexpert.linkedlists;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class LruCache {

    @Test
    public void shouldPassSimpleTestCase() {
        LRUCache lruCache = new LRUCache(3);
        lruCache.insertKeyValuePair("b", 2);
        lruCache.insertKeyValuePair("a", 1);
        lruCache.insertKeyValuePair("c", 3);
        assertTrue(lruCache.getMostRecentKey() == "c");
        assertTrue(lruCache.getValueFromKey("a").value == 1);
        assertTrue(lruCache.getMostRecentKey() == "a");
        lruCache.insertKeyValuePair("d", 4);
        LRUResult evictedValue = lruCache.getValueFromKey("b");
        assertTrue(evictedValue == null || evictedValue.found == false);
        lruCache.insertKeyValuePair("a", 5);
        assertTrue(lruCache.getValueFromKey("a").value == 5);
    }


    static class LRUCache {
        int maxSize;
        Map<String, Integer> map;
        LinkedList<String> leastRecentlyUsed = new LinkedList<>();
        int currentSize = 0;


        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
            map = new HashMap<>(maxSize);
        }

        public void insertKeyValuePair(String key, int value) {
            // Write your code here.
            if (currentSize < maxSize) {
                map.put(key, value);
                leastRecentlyUsed.addFirst(key);
                currentSize += 1;
            } else {
                String last = leastRecentlyUsed.removeLast();
                map.remove(last);
                leastRecentlyUsed.addFirst(key);
                map.put(key, value);
            }
        }

        public LRUResult getValueFromKey(String key) {
            // Write your code here.
            //return null;
            if (map.containsKey(key)) {
                leastRecentlyUsed.remove(key);
                leastRecentlyUsed.addFirst(key);
                return new LRUResult(true, map.get(key));
            }

            return new LRUResult(false, -1);
        }

        public String getMostRecentKey() {
            // Write your code here.
            //return null;
            return leastRecentlyUsed.getFirst();
        }
    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }
}



