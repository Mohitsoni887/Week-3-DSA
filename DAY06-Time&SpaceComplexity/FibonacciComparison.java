/*
 *  Problem Statement: Recursive vs Iterative Fibonacci Computation
Objective:
Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
Approach:
Recursive:
public static int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

Iterative:
public static int fibonacciIterative(int n) {
    int a = 0, b = 1, sum;
    for (int i = 2; i <= n; i++) {
        sum = a + b;
        a = b;
        b = sum;
    }
    return b;
}
Comparative Analysis:
Fibonacci (N)               Recursive (O(2ⁿ))                     Iterative (O(N))
10                               1ms                                 0.01ms
30                               5s                                  0.05ms
50                               Unfeasible (>1hr)                   0.1ms
Expected Result:
Recursive approach is infeasible for large values of N due to exponential growth.
The iterative approach is significantly faster and memory-efficient.
 */

public class FibonacciComparison {

    // Recursive Fibonacci (Exponential Time Complexity: O(2ⁿ))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time Complexity: O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50}; // Values of N to compare

        System.out.println("Fibonacci (N) | Recursive Time (ms) | Iterative Time (ms)");
        System.out.println("---------------------------------------------------------");

        for (int n : testCases) {
            // Measure Recursive Execution Time
            long startRecursive = System.nanoTime();
            // Limiting recursive test to avoid unfeasible execution
            if (n <= 30) {
                fibonacciRecursive(n);
            }
            long recursiveTime = (System.nanoTime() - startRecursive) / 1_000_000; // Convert to ms

            // Measure Iterative Execution Time
            long startIterative = System.nanoTime();
            fibonacciIterative(n);
            long iterativeTime = (System.nanoTime() - startIterative) / 1_000_000; // Convert to ms

            // Print Results
            System.out.println(n + "            | " +
                    (n > 30 ? "Unfeasible (>1hr)" : recursiveTime + " ms") + "    | " +
                    iterativeTime + " ms");
        }
    }
}
