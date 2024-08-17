package com.tuf.patterns;

public class PatternFifteen {
    public static void main(String args[]) {
        int n = 6;
        for (int i = 1; i <= n; i++) {
            int charStart = 65;
            for (int j = n; j >= i; j--) {
                System.out.print((char) charStart++ + " ");
            }
            System.out.println();
        }
    }
}
