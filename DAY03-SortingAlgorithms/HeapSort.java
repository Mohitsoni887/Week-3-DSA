/*
 * Heap Sort - Sort Job Applicants by Salary
Problem Statement:
A company receives job applications with different expected salary demands. Implement Heap Sort to sort these salary demands in ascending order.
Hint:
Build a Max Heap from the array.
Extract the largest element (root) and place it at the end.
Reheapify the remaining elements and repeat until sorted.

 */
import java.util.Arrays;

public class HeapSort {
    
    // Method to perform Heap Sort
    public static void heapSort(double[] salaries) {
        int n = salaries.length;
        
        // Build a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        
        // Extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            swap(salaries, 0, i);
            heapify(salaries, i, 0);
        }
    }

    // Heapify method to maintain max heap property
    private static void heapify(double[] salaries, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }
        
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(salaries, i, largest);
            heapify(salaries, n, largest);
        }
    }

    // Swap method
    private static void swap(double[] salaries, int i, int j) {
        double temp = salaries[i];
        salaries[i] = salaries[j];
        salaries[j] = temp;
    }

    // Main method to test Heap Sort
    public static void main(String[] args) {
        double[] expectedSalaries = {55000, 70000, 50000, 80000, 60000};
        System.out.println("Before sorting: " + Arrays.toString(expectedSalaries));
        
        heapSort(expectedSalaries);
        
        System.out.println("After sorting: " + Arrays.toString(expectedSalaries));
    }
}