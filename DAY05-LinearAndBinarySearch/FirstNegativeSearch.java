/*
 * Linear Search Problem 1: Search for the First Negative Number
Problem:
You are given an integer array. Write a program that performs Linear Search to find the first negative number in the array. If a negative number is found, return its index. If no negative number is found, return -1.
Approach:
Iterate through the array from the start.
Check if the current element is negative.
If a negative number is found, return its index.
If the loop completes without finding a negative number, return -1.

 */
public class FirstNegativeSearch{
    public static int findFirstNegative(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                return i; // Return the index of the first negative number
        }
    }
    return -1; //no negative numbers found
}

public static void main(String[] args){
    int[] arr = {5,2,53,323,-45,532,-43};
    int result = findFirstNegative(arr);

    if(result != -1){
        System.out.println("First negative number found at index: " + result);
    }
    else{
        System.out.println("No negative numbers found in the array");
    }
}
}

