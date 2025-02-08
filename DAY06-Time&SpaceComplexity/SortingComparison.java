/*
 * Sorting Large Data Efficiently
Objective:
Compare sorting algorithms Bubble Sort (O(N²)), Merge Sort (O(N log N)), and Quick Sort (O(N log N)).
Approach:
Bubble Sort: Repeated swapping (inefficient for large data).
Merge Sort: Divide & Conquer approach (stable).
Quick Sort: Partition-based approach (fast but unstable).
Comparative Analysis:
Dataset Size (N)          Bubble Sort (O(N²))               Merge Sort (O(N log N))             Quick Sort (O(N log N))
1,000                       50ms                               5ms                                  3ms
10,000                      5s                                 50ms                                 30ms
1,000,000                   Unfeasible (>1hr)                  3s                                   2s
Expected Result:
Bubble Sort is impractical for large datasets.
Merge Sort & Quick Sort perform well.
 */

import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort - O(N²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort - O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = Arrays.copyOfRange(arr, left, mid + 1);
        int[] R = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    // Quick Sort - O(N log N)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1_000, 10_000, 1_000_000};
        Random random = new Random();

        System.out.println("Dataset Size  | Bubble Sort (ms) | Merge Sort (ms) | Quick Sort (ms)");
        System.out.println("---------------------------------------------------------------------");

        for (int size : datasetSizes) {
            int[] data = new int[size];

            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }

            // Copy arrays for fair comparison
            int[] bubbleData = Arrays.copyOf(data, data.length);
            int[] mergeData = Arrays.copyOf(data, data.length);
            int[] quickData = Arrays.copyOf(data, data.length);

            // Bubble Sort
            long start = System.nanoTime();
            if (size <= 10_000) {  // Prevent excessive execution time
                bubbleSort(bubbleData);
            }
            long bubbleTime = (size <= 10_000) ? (System.nanoTime() - start) / 1_000_000 : -1;

            // Merge Sort
            start = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeTime = (System.nanoTime() - start) / 1_000_000;

            // Quick Sort
            start = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickTime = (System.nanoTime() - start) / 1_000_000;

            System.out.println(size + "        | " + 
                (bubbleTime == -1 ? "Unfeasible" : bubbleTime + " ms") + "      | " + 
                mergeTime + " ms        | " + quickTime + " ms");
        }
    }
}
