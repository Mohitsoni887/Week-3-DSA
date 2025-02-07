/*
 * Binary Search Problem 2: Find the Peak Element in an Array
Problem:
A peak element is an element that is greater than its neighbors. Write a program that performs Binary Search to find a peak element in an array. If there are multiple peak elements, return any one of them.
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid] is a peak element.
If arr[mid] < arr[mid - 1], then search the left half, updating right = mid - 1.
If arr[mid] < arr[mid + 1], then search the right half, updating left = mid + 1.
Continue until a peak element is found.
 */
public class PeakElementArrayBinary {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 3, 4};
        int index = findPeakElement(arr);
        System.out.println("Index of the peak element: " + index);
        System.out.println("Peak element: " + arr[index]);
    }

    public static int findPeakElement(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Edge case: check if mid is the peak
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && 
                (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }
            // If left neighbor is greater, move to the left half
            else if (mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            }
            // Otherwise, move to the right half
            else {
                start = mid + 1;
            }
        }
        return start; // The peak index
    }
}

