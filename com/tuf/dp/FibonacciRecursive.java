package com.tuf.dp;

import java.util.ArrayList;
import java.util.Collections;

public class FibonacciRecursive {
    public static int fibo(int n) { // fibo at Nth index
        if (n <= 1)
            return n;
        return (fibo(n - 1) + fibo(n - 2));
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("fibonacci at " + n + " position(0 based) is  :" + fibo(n));
    }
}
