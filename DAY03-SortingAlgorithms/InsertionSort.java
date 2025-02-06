/*
*Insertion Sort - Sort Employee IDs
Problem Statement:
A company stores employee IDs in an unsorted array. Implement Insertion Sort to sort the employee IDs in ascending order.
Hint:
Divide the array into sorted and unsorted parts.
Pick an element from the unsorted part and insert it into its correct position in the sorted part.
Repeat for all elements
*/

import java.util.Arrays;

public class InsertionSort {
    // Function to perform Insertion Sort
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key; // Insert key at the correct position
        }
    }

    // Function to print the array
    public static void printArray(int[] employeeIDs) {
        System.out.println(Arrays.toString(employeeIDs));
    }

    public static void main(String[] args) {
        int[] employeeIDs = {103, 101, 105, 100, 102, 104};

        System.out.print("Original Employee IDs: ");
        printArray(employeeIDs);

        insertionSort(employeeIDs);

        System.out.print("Sorted Employee IDs: ");
        printArray(employeeIDs);
    }
}
