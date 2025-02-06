/*
 * Counting Sort - Sort Student Ages
Problem Statement:
A school collects students’ ages (ranging from 10 to 18) and wants them sorted. Implement Counting Sort for this task.
Hint:
Create a count array to store the frequency of each age.
Compute cumulative frequencies to determine positions.
Place elements in their correct positions in the output array.

 */

 import java.util.Arrays;

 public class CountingSort {
     
     // Method to perform Counting Sort
     public static void countingSort(int[] ages) {
         int minAge = 10, maxAge = 18;
         int range = maxAge - minAge + 1;
         int[] count = new int[range];
         int[] output = new int[ages.length];
         
         // Count occurrences of each age
         for (int age : ages) {
             count[age - minAge]++;
         }
         
         // Compute cumulative counts
         for (int i = 1; i < range; i++) {
             count[i] += count[i - 1];
         }
         
         // Place elements in their correct positions
         for (int i = ages.length - 1; i >= 0; i--) {
             output[count[ages[i] - minAge] - 1] = ages[i];
             count[ages[i] - minAge]--;
         }
         
         // Copy sorted output back to the original array
         System.arraycopy(output, 0, ages, 0, ages.length);
     }
 
     // Main method to test Counting Sort
     public static void main(String[] args) {
         int[] studentAges = {12, 15, 11, 18, 14, 13, 17, 16, 10, 12};
         System.out.println("Before sorting: " + Arrays.toString(studentAges));
         
         countingSort(studentAges);
         
         System.out.println("After sorting: " + Arrays.toString(studentAges));
     }
 }
 
