package com.tuf.recursion;

public class Fibonacci {

    public int fibo(int n) {
        // System.out.println("LOOOOOOOOOL");
        if (n <= 1)
            return n; // 0 and 1
        else
            return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibo(5));
    }
}
