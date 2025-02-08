/*
 * 1. Problem Statement: Search a Target in a Large Dataset
Objective:
Compare the performance of Linear Search (O(N)) and Binary Search (O(log N)) on different dataset sizes.
Approach:
Linear Search: Scan each element until the target is found.
Binary Search: Sort the data first (O(N log N)), then perform O(log N) search.
Comparative Analysis:
Dataset Size (N)      Linear Search (O(N))          Binary Search (O(log N))
1,000                 1ms                               0.01ms
10,000                10ms                              0.02ms
1,000,000             1s                                0.1ms
Expected Result:
Binary Search performs much better for large datasets, provided data is sorted.
 */

import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    
    // Linear Search - O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found
            }
        }
        return -1; // Not Found
    }

    // Binary Search - O(log N)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1; // Not Found
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000};
        Random random = new Random();

        System.out.println("Dataset Size  | Linear Search (ms) | Binary Search (ms)");
        System.out.println("--------------------------------------------------------");

        for (int size : datasetSizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10); // Populate array with random numbers
            }
            
            int target = data[random.nextInt(size)]; // Pick a random target

            // Measure Linear Search
            long start = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - start;

            // Sort Data for Binary Search
            Arrays.sort(data);

            // Measure Binary Search
            start = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;

            System.out.println(size + "        | " + (linearTime / 1e6) + " ms          | " + (binaryTime / 1e6) + " ms");
        }
    }
}
