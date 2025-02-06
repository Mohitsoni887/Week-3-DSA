/*
 * Longest Consecutive Sequence
Problem: Given an unsorted array, find the length of the longest consecutive elements sequence.
Hint: Use a hash map to store elements and check for consecutive elements efficiently.
 */

import java.util.*;

public class LongestConsecutiveSequence {
    
    // Function to find the length of the longest consecutive sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        
        // Insert all elements into the set
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        // Iterate through each number
        for (int num : nums) {
            // Check if this number is the start of a sequence (num-1 does not exist)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Expand the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                // Update the maximum length found
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(arr));
    }
}
