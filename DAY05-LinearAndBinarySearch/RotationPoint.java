/*
 * Binary Search Problem 1: Find the Rotation Point in a Rotated Sorted Array
Problem:
You are given a rotated sorted array. Write a program that performs Binary Search to find the index of the smallest element in the array (the rotation point).
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[right], then the smallest element is in the right half, so update left = mid + 1.
If arr[mid] < arr[right], the smallest element is in the left half, so update right = mid.
Continue until left equals right, and then return arr[left] (the rotation point).
 */

public class RotationPoint {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        // Perform binary search to find the rotation point
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the rightmost element,
            // the smallest element is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the smallest element is in the left half (including mid)
                right = mid;
            }
        }

        // When left equals right, we have found the rotation point (smallest element)
        return arr[left];
    }

    public static void main(String[] args) {
        int[] rotatedArray = {6, 7, 9, 15, 19, 2, 3}; // Example rotated sorted array
        int rotationPoint = findRotationPoint(rotatedArray);

        System.out.println("The rotation point (smallest element) is: " + rotationPoint);
    }
}
