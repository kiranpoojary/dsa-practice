package com.tuf.mathematics;

public class LCM {
    public static void main(String[] args) {
        int a = 15;
        int b = 20;
        int largest = a > b ? a : b;
        int largestInput = largest;
        int smallest = a < b ? a : b;
        while (largest % smallest != 0) {
            largest = largest + largestInput;
        }

        System.out.println("LCM :" + largest);
    }
}
