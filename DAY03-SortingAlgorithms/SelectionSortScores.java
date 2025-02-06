/*
 * Selection Sort - Sort Exam Scores
Problem Statement:
A university needs to sort students’ exam scores in ascending order. Implement Selection Sort to achieve this.
Hint:
Find the minimum element in the array.
Swap it with the first unsorted element.
Repeat the process for the remaining elements.

 */

import java.util.Arrays;

public class SelectionSortScores {
    // Function to perform Selection Sort
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the first element is the smallest
            
            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j; // Update the index of the minimum element
                }
            }
            
            // Swap the found minimum element with the first element of the unsorted part
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    // Function to print the array
    public static void printArray(int[] scores) {
        System.out.println(Arrays.toString(scores));
    }

    public static void main(String[] args) {
        int[] scores = {85, 72, 90, 60, 78, 88, 95};

        System.out.print("Original Exam Scores: ");
        printArray(scores);

        selectionSort(scores);

        System.out.print("Sorted Exam Scores: ");
        printArray(scores);
    }
}
