package com.tuf.recursion;

public class PrintOneToNBacktrack {
    public void print(int n) {
        if (n == 0)
            return;
        else {
            print(n - 1);
            System.out.println(n);
        }

    }

    public static void main(String[] args) {
        PrintOneToNBacktrack p = new PrintOneToNBacktrack();
        p.print(6);
    }
}
