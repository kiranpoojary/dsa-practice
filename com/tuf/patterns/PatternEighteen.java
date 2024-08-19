package com.tuf.patterns;

public class PatternEighteen {
    public static void main(String args[]) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            int charCode = 65 + n - i;
            for (int j = 1; j <= i; j++) {
                System.out.print((char) (charCode) + " ");
                ++charCode;
            }
            System.out.println();
        }
    }
}