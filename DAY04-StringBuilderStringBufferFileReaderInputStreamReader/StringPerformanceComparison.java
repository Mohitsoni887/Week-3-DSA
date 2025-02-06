/*
 * StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation
Problem:
Write a program that compares the performance of StringBuffer and StringBuilder for concatenating strings. For large datasets (e.g., concatenating 1 million strings), compare the execution time of both classes.
Approach:
Initialize two StringBuffer and StringBuilder objects.
Perform string concatenation in both objects, appending 1 million strings (e.g., "hello").
Measure the time taken to complete the concatenation using System.nanoTime() for both StringBuffer and StringBuilder.
Output the time taken by both classes for comparison.

 */
public class StringPerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // Measure time for StringBuffer
        long startTime1 = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTime1 = System.nanoTime();
        long durationBuffer = endTime1 - startTime1;

        // Measure time for StringBuilder
        long startTime2 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTime2 = System.nanoTime();
        long durationBuilder = endTime2 - startTime2;

        // Output results
        System.out.println("Time taken by StringBuffer: " + (durationBuffer / 1_000_000) + " ms");
        System.out.println("Time taken by StringBuilder: " + (durationBuilder / 1_000_000) + " ms");
    }
}
