/*
 * Implement a Custom Hash Map
Problem: Design and implement a basic hash map class with operations for insertion, deletion, and retrieval.
Hint: Use an array of linked lists to handle collisions using separate chaining.
 */

import java.util.LinkedList;

class MyHashMap<K, V> {
    private static final int SIZE = 16; // Default bucket size
    private LinkedList<Entry<K, V>>[] buckets;

    // Entry class to store key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize hash map
    public MyHashMap() {
        buckets = new LinkedList[SIZE];
    }

    // Hash function
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing key
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value)); // Insert new key-value pair
    }

    // Retrieve a value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) return;

        buckets[index].removeIf(entry -> entry.key.equals(key));
    }

    // Display hash map contents
    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + "=" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    // Main function to test the hash map
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        System.out.println("Value for Bob: " + map.get("Bob")); // 30
        map.put("Bob", 32);
        System.out.println("Updated value for Bob: " + map.get("Bob")); // 32

        map.remove("Alice");
        System.out.println("Value for Alice after removal: " + map.get("Alice")); // null

        map.printMap();
    }
}
