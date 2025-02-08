/*
 * Problem Statement: Comparing Different Data Structures for Searching
Objective:
Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching elements.
Approach:
Array: Linear search (O(N)).
HashSet: Uses hashing (O(1) on average).
TreeSet: Balanced BST (O(log N)).
Comparative Analysis:
Dataset Size (N)               Array Search (O(N))               HashSet Search (O(1))                   TreeSet Search (O(log N))
1,000                              1ms                               0.01ms                                      0.1ms
100,000                            100ms                             0.01ms                                      10ms
1,000,000                          1s                                0.01ms                                      20ms
Expected Result:
HashSet is fastest for lookups but requires extra memory.
TreeSet maintains order but is slightly slower than HashSet.
 */

import java.util.*;

public class DataStructureSearchComparison {

    // Linear Search in Array (O(N))
    public static boolean searchInArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) return true;
        }
        return false;
    }

    // Search in HashSet (O(1) average case)
    public static boolean searchInHashSet(HashSet<Integer> set, int target) {
        return set.contains(target);
    }

    // Search in TreeSet (O(log N))
    public static boolean searchInTreeSet(TreeSet<Integer> tree, int target) {
        return tree.contains(target);
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 100_000, 1_000_000};
        
        System.out.println("Dataset Size | Array Search (ms) | HashSet Search (ms) | TreeSet Search (ms)");
        System.out.println("-------------------------------------------------------------------------");

        for (int size : datasetSizes) {
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            // Populate the data structures
            for (int i = 0; i < size; i++) {
                array[i] = i;
                hashSet.add(i);
                treeSet.add(i);
            }

            int target = size - 1; // Searching for the last element

            // Measure Array Search Time
            double startArray = System.nanoTime();
            searchInArray(array, target);
            double arrayTime = (System.nanoTime() - startArray) / 1_000_000; // Convert to ms

            // Measure HashSet Search Time
            double startHashSet = System.nanoTime();
            searchInHashSet(hashSet, target);
            double hashSetTime = (System.nanoTime() - startHashSet) / 1_000_000; // Convert to ms

            // Measure TreeSet Search Time
            double startTreeSet = System.nanoTime();
            searchInTreeSet(treeSet, target);
            double treeSetTime = (System.nanoTime() - startTreeSet) / 1_000_000; // Convert to ms

            // Print Results
            System.out.println(size + "          | " + arrayTime + " ms               | " + hashSetTime + " ms                | " + treeSetTime + " ms");
        }
    }
}
