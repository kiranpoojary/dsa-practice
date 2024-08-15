package com.tuf.mathematics;

public class GCD {
    public static void main(String[] args) {
        int a = 12;
        int b = 56;
        int gcd = 1;
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
                gcd = b;
            } else {
                b = b % a;
                gcd = a;
            }
        }
        System.out.println("GCD :" + gcd);
    }
}
