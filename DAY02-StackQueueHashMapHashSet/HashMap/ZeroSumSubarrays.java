/*
 * Find All Subarrays with Zero Sum
Problem: Given an array, find all subarrays whose elements sum up to zero.
Hint: Use a hash map to store the cumulative sum and its frequency. If a sum repeats, a zero-sum subarray exists.
 */

import java.util.*;

public class ZeroSumSubarrays {
    
    // Function to find all subarrays with a sum of zero
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // Hash map to store cumulative sum and its list of indices
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int cumulativeSum = 0;

        // Add base case: cumulative sum 0 appears at index -1
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update cumulative sum
            cumulativeSum += arr[i];

            // If cumulative sum exists in map, it means we found zero-sum subarrays
            if (sumMap.containsKey(cumulativeSum)) {
                for (int start : sumMap.get(cumulativeSum)) {
                    result.add(new int[]{start + 1, i});  // Subarray from (start+1) to i
                }
            }

            // Store current index in hash map
            sumMap.computeIfAbsent(cumulativeSum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, -2, 2, -3};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        // Print the subarrays with zero sum
        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : subarrays) {
            System.out.println("Start index: " + subarray[0] + ", End index: " + subarray[1]);
        }
    }
}
