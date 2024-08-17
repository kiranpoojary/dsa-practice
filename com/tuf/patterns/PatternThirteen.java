package com.tuf.patterns;

public class PatternThirteen {
    public static void main(String args[]) {
        int n = 6;
        int rowStart = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++, rowStart++) {
                System.out.print(rowStart + " ");
            }
            System.out.println();
        }
    }
}
