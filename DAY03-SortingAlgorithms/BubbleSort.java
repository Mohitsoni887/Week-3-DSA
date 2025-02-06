/*
 * Bubble Sort - Sort Student Marks
Problem Statement:
A school maintains student marks in an array. Implement Bubble Sort to sort the student marks in ascending order.
Hint:
Traverse through the array multiple times.
Compare adjacent elements and swap if needed.
Repeat the process until no swaps are required.
 */
import java.util.Arrays;
public class BubbleSort {
    
    public static void bubbleSort(int[] marks){
        int n=marks.length;
        boolean swapped;

        for(int i=0;i<n-1;i++){
           swapped = false;

           for(int j=0;j<n-i-1;j++){
            if(marks[j]>marks[j+1]){
                int temp = marks[j];
                marks[j] = marks[j+1];
                marks[j+1] = temp;

                swapped = true;
            }
           }
           if(!swapped) 
           break;
        }
    }

    // Method to print sorted array
    public static void printArray(int[] marks) {
        System.out.println(Arrays.toString(marks));
    }

    public static void main(String[] args) {
        int[] marks = {85, 92, 78, 65, 90, 88, 76, 95};

        System.out.print("Original Marks: ");
        printArray(marks);

        bubbleSort(marks);

        System.out.print("Sorted Marks: ");
        printArray(marks);
    }
}