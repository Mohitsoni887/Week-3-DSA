/*
 *  Quick Sort - Sort Product Prices
Problem Statement:
An e-commerce company wants to display product prices in ascending order. Implement Quick Sort to sort the product prices.
Hint:
Pick a pivot element (first, last, or random).
Partition the array such that elements smaller than the pivot are on the left and larger ones are on the right.
Recursively apply Quick Sort on left and right partitions.

 */

import java.util.Arrays;

public class QuickSort {
    
    // Method to perform Quick Sort
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition method
    private static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                swap(prices, i, j);
            }
        }
        swap(prices, i + 1, high);
        return i + 1;
    }

    // Swap method
    private static void swap(double[] prices, int i, int j) {
        double temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }

    // Main method to test Quick Sort
    public static void main(String[] args) {
        double[] productPrices = {199.99, 49.99, 299.99, 99.99, 149.99};
        System.out.println("Before sorting: " + Arrays.toString(productPrices));
        
        quickSort(productPrices, 0, productPrices.length - 1);
        
        System.out.println("After sorting: " + Arrays.toString(productPrices));
    }
}
