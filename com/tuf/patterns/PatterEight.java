package com.tuf.patterns;

public class PatterEight {
    public static void main(String args[]) {
        int n = 5;
        for (int i = 0; i < n; i++) {

            for (int j = n - i; j < n; j++) {
                System.out.print("  ");
            }

            for (int k = i; k < n; k++) {
                System.out.print("* ");
            }

            for (int l = 0; l < n - i - 1; l++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }
}
