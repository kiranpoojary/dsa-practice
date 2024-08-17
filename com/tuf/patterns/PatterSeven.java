package com.tuf.patterns;

public class PatterSeven {
    public static void main(String args[]) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = n - i - 1; k < n; k++) {
                System.out.print("*");
            }
            for (int k = n - i; k < n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
