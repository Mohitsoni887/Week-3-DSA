/*
 * Two Sum Problem
Problem: Given an array and a target sum, find two indices such that their values add up to the target.
Hint: Use a hash map to store the index of each element as you iterate. Check if target - current_element exists in the map.
 */

import java.util.*;

public class TwoSum {
    
    // Function to find two indices that sum to the target
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (numToIndex.containsKey(complement)) {
                return new int[]{numToIndex.get(complement), i}; // Found the pair
            }

            // Store the current number and its index
            numToIndex.put(nums[i], i);
        }

        return new int[]{-1, -1}; // Return -1 if no pair found
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);
        System.out.println("Indices: " + Arrays.toString(result)); // Output: [0, 1]
    }
}
