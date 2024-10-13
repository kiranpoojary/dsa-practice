package com.tuf.dp;

import java.util.ArrayList;
import java.util.Collections;

public class FibonaciTabulationSpaceOptimized {
    // TC: O(n)
    // TC: O(1)
    public static int fibo(int n) { // fibo at Nth index
        if (n <= 1)
            return n;
        int prev2 = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int nextFibo = prev + prev2;
            prev2 = prev;
            prev = nextFibo;
        }
        return prev;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("fibonacci at " + n + " position(0 based) is  :" + fibo(n));
    }
}
