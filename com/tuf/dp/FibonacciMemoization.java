package com.tuf.dp;

import java.util.ArrayList;
import java.util.Collections;

public class FibonacciMemoization {
    // Recursion
    // TC: O(n)
    // SC: O(n)+O(n)
    public static int fibo(int n, ArrayList<Integer> memo) { // fibo at Nth index
        if (n <= 1)
            return n;

        if (memo.get(n) != -1)
            return memo.get(n);
        memo.set(n, fibo(n - 1, memo) + fibo(n - 2, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> memo = new ArrayList<>(Collections.nCopies(n + 1, -1));
        System.out.println("fibonacci at " + n + " position(0 based) is  :" + fibo(n, memo));
    }
}
