/*
 * Check for a Pair with Given Sum in an Array
Problem: Given an array and a target sum, find if there exists a pair of elements whose sum is equal to the target.
Hint: Store visited numbers in a hash map and check if target - current_number exists in the map.

 */

import java.util.*;

public class PairWithGivenSum {
    
    // Function to check if a pair with the given sum exists
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seenNumbers = new HashSet<>();
        
        // Traverse the array
        for (int num : arr) {
            int complement = target - num;
            
            // Check if the complement exists in the set
            if (seenNumbers.contains(complement)) {
                return true; // Found a valid pair
            }
            
            // Add current number to the set
            seenNumbers.add(num);
        }
        
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 9};
        int target = 10;

        // Check if a pair exists
        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair with given sum exists.");
        } else {
            System.out.println("No such pair found.");
        }
    }
}
