/*
*Challenge Problem (for both Linear and Binary Search)
Problem:
You are given a list of integers. Write a program that uses Linear Search to find the first missing positive integer in the list and Binary Search to find the index of a given target number.
Approach:
Linear Search for the first missing positive integer:
Iterate through the list and mark each number in the list as visited (you can use negative marking or a separate array).
Traverse the array again to find the first positive integer that is not marked.
Binary Search for the target index:
After sorting the array, perform binary search to find the index of the given target number.
Return the index if found, otherwise return -1.
*/
import java.util.Arrays;

public class SearchChallenge {
    
    // Function to find the first missing positive integer using Linear Search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Mark numbers (indexing starts from 1)
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Step 2: Find the first missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // First missing positive integer
            }
        }
        return n + 1; // If all numbers are present, return the next integer
    }

    // Function to find the index of a target number using Binary Search
    public static int binarySearch(int[] nums, int target) {
        Arrays.sort(nums); // Ensure the array is sorted
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found, return index
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int target = 3;

        // Find first missing positive integer
        int missingNumber = findFirstMissingPositive(nums);
        System.out.println("First Missing Positive Integer: " + missingNumber);

        // Find target index using Binary Search
        int index = binarySearch(nums, target);
        System.out.println("Index of " + target + " (Binary Search): " + index);
    }
}
