package com.chrzanop.map;

import java.util.Objects;

public class SimpleHashMap<K,V> {

    // Simple test
    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("apple", 3);  // Update value

        System.out.println("apple = " + map.get("apple"));   // Output: 3
        System.out.println("banana = " + map.get("banana")); // Output: 2
        System.out.println("size = " + map.size());          // Output: 2
    }

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;  // For handling collisions (chaining)

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node<K, V>[] table;  // Array of buckets
    private static final int INITIAL_CAPACITY = 16;  // Default size
    private int size = 0;

    @SuppressWarnings("unchecked")
    public SimpleHashMap() {
        table = (Node<K, V>[]) new Node[INITIAL_CAPACITY];
    }

    // Hash function to calculate index for a key
    private int hash(Object key) {
        return (key == null) ? 0 : Math.abs(key.hashCode()) % table.length;
    }

    // Put key-value pair into the map
    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> head = table[index];

        // Check if key already exists, update value if found
        for (Node<K, V> curr = head; curr != null; curr = curr.next) {
            if (Objects.equals(curr.key, key)) {
                curr.value = value;
                return;
            }
        }

        // Insert new node at the beginning of the chain
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        table[index] = newNode;
        size++;
    }

    // Get value by key
    public V get(K key) {
        int index = hash(key);
        Node<K, V> curr = table[index];

        while (curr != null) {
            if (Objects.equals(curr.key, key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;  // Not found
    }

    // Returns the number of key-value pairs
    public int size() {
        return size;
    }

//    private Node<K,V>[] table;
//
//    private int capacity =  10;
//
//    private int threshold = 1 << 4;
//
//
//    public MapCustom() {
//    }
//
//    public void put(K key, V value) {
//        int hash = key.hashCode();
//
//        Node<K,V>[] tab; Node<K,V> p; int n, i;
//        if ((tab = table) == null || (n = tab.length) == 0)
//            n = (tab = resize()).length;
//
//
//    }
//
//    Node<K,V>[] resize() {
//        Node<K,V>[] oldTab = table;
//        int oldCap = oldTab == null ? 0 : oldTab.length;
//        int oldThreshold = threshold;
//        int newCap, newThr = 0;
//
//
//
//        threshold = newThr;
//        @SuppressWarnings({"rawtypes","unchecked"})
//        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
//        table = newTab;
//
//        return newTab;
//    }
//
//    private static class Node<K,V> {
//       private K key;
//       private V value;
//       private int hash;
//       private Node<K,V> next;
//
//        public Node(K key, V value, int hash, Node<K,V> next) {
//            this.key = key;
//            this.value = value;
//            this.hash = hash;
//            this.next = next;
//        }
//
//        public final K getKey()        { return key; }
//        public final V getValue()      { return value; }
//        public final String toString() { return key + "=" + value; }
//
//        public final int hashCode() {
//            return Objects.hashCode(key) ^ Objects.hashCode(value);
//        }
//    }
}
