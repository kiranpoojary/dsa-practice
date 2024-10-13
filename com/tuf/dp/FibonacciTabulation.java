package com.tuf.dp;

import java.util.ArrayList;
import java.util.Collections;

public class FibonacciTabulation {

    // TC: O(n)
    // SC: O(n)
    public static int fibo(int n, ArrayList<Integer> memo) { // fibo at Nth index
        if (n <= 1)
            return n;
        memo.set(0, 0);
        memo.set(1, 1);
        for (int i = 2; i < memo.size(); i++) {
            memo.set(i, memo.get(i - 1) + memo.get(i - 2));
        }
        return memo.get(n);
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Integer> memo = new ArrayList<>(Collections.nCopies(n + 1, -1));
        System.out.println("fibonacci at " + n + " position(0 based) is  :" + fibo(n, memo));
    }
}
