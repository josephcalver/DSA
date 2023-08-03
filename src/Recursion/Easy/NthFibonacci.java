package Recursion.Easy;

import java.util.Arrays;

public class NthFibonacci {

    public static void main(String[] args) {

//      0, 1, 1, 2, 3, 5

        int nthFibRecursive = nthFibonacciRecursive(6);
        System.out.println("The 6th Fibonacci number = " + nthFibRecursive);

        int[] memo = new int[6 + 1];
        Arrays.fill(memo, -1);
        int nthFibMemoized = nthFibonacciMemoized(6, memo);
        System.out.println("The 6th Fibonacci number = " + nthFibMemoized);

        int nthFibIterative = nthFibonacciIterative(6);
        System.out.println("The 6th Fibonacci number = " + nthFibIterative);

    }

//    O(2^n) time (we make 2 calls n times)
//    O(n) space
    public static int nthFibonacciRecursive(int n) {

        if (n == 2) return 1;
        if (n == 1) return 0;

        return nthFibonacciRecursive(n - 1) + nthFibonacciRecursive(n - 2);

    }

//    O(n) time | O(n) space
    public static int nthFibonacciMemoized(int n, int[] memo) {

        if (n == 1) return 0;
        if (n == 2) return 1;

        if (memo[n] != -1) {

            return memo[n];

        } else {

            memo[n] = nthFibonacciMemoized(n - 1, memo) + nthFibonacciMemoized(n - 2, memo);

        }

        return memo[n];

    }

//    O(n) time | O(1) space
    public static int nthFibonacciIterative(int n) {

        if (n == 1) return 0;
        if (n == 2) return 1;

        int twoPrevious = 0, onePrevious = 1, current = 0, counter = 3;

        while (counter <= n) {

            current = twoPrevious + onePrevious;
            twoPrevious = onePrevious;
            onePrevious = current;

            counter++;

        }

        return current;

    }

}
