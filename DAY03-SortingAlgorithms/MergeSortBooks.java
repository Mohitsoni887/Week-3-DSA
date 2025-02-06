/*
 * Merge Sort - Sort an Array of Book Prices
Problem Statement:
A bookstore maintains a list of book prices in an array. Implement Merge Sort to sort the prices in ascending order.
Hint:
Divide the array into two halves recursively.
Sort both halves individually.
Merge the sorted halves by comparing elements.
 */

import java.util.Arrays;

public class MergeSortBooks {
    // Function to perform Merge Sort
    public static void mergeSort(double[] bookPrices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively sort first and second halves
            mergeSort(bookPrices, left, mid);
            mergeSort(bookPrices, mid + 1, right);

            // Merge sorted halves
            merge(bookPrices, left, mid, right);
        }
    }

    // Function to merge two sorted halves
    public static void merge(double[] bookPrices, int left, int mid, int right) {
        int n1 = mid - left + 1; // Size of left subarray
        int n2 = right - mid;    // Size of right subarray

        // Create temporary arrays
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) leftArray[i] = bookPrices[left + i];
        for (int j = 0; j < n2; j++) rightArray[j] = bookPrices[mid + 1 + j];

        // Merge the temporary arrays back
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                bookPrices[k] = leftArray[i];
                i++;
            } else {
                bookPrices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            bookPrices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            bookPrices[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Function to print the array
    public static void printArray(double[] bookPrices) {
        System.out.println(Arrays.toString(bookPrices));
    }

    public static void main(String[] args) {
        double[] bookPrices = {499.99, 150.50, 299.75, 200.00, 350.25, 120.99};

        System.out.print("Original Book Prices: ");
        printArray(bookPrices);

        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.print("Sorted Book Prices: ");
        printArray(bookPrices);
    }
}
