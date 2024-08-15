package com.tuf.mathematics;

public class PalindromeNumber {
    public static void main(String[] args) {
        int num = 187781;
        int tempNum = num;
        int rev = 0;
        int rem = 0;
        while (tempNum > 0) {
            rem = tempNum % 10;
            rev = rev * 10 + rem;
            tempNum /= 10;
        }
        if (num == rev)
            System.out.println("PALINDROME");
        else
            System.out.println("NOT PALINDROME");

    }
}
