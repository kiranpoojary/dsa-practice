package com.tuf.mathematics;

public class ReverseDigit {
    public static void main(String[] args) {
        int num = 123456;
        int numCopy = num;
        int rev = 0;
        int rem = 0;
        while (num > 0) {
            rem = num % 10;
            rev = rev * 10 + rem;
            num /= 10;
        }
        System.out.println("Original Number :" + numCopy);
        System.out.println("Reversed Number :" + rev);

    }
}
