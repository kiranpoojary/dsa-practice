package com.tuf.recursion;

public class PrintNToOne {

    public int print(int n) {
        if (n == 0) {
            return 0;
        } else {
            System.out.println(n);
            return print(n - 1);
        }
    }

    public static void main(String[] args) {
        PrintNToOne p = new PrintNToOne();
        p.print(7);
    }
}
