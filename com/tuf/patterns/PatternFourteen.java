package com.tuf.patterns;

public class PatternFourteen {
    public static void main(String args[]) {
        int n = 6;
        for (int i = 1; i <= n; i++) {
            int charStart = 65;
            for (int j = 1; j <= i; j++) {
                System.out.print((char) charStart++ + " ");
            }
            System.out.println();
        }
    }
}
