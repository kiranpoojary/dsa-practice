package com.tuf.recursion;

public class PrintOneToN {

    public int print(int i, int n) {
        if (i > n) {
            return 0;
        } else {
            System.out.println(i);
            return print(i + 1, n);
        }
    }

    public static void main(String[] args) {
        PrintOneToN p = new PrintOneToN();
        p.print(1, 6);
    }
}
