package com.tuf.mathematics;

public class CountDigit {

    public static void main(String[] args) {
        int num = 123456;
        int numCopy = num;
        int count = 0;
        while (num > 0) {
            ++count;
            num = num / 10;
        }
        System.out.println("Digit Count :" + count);
        // OR
        int count2 = (int) Math.log10(numCopy) + 1;
        System.out.println("Digit Count :" + count2);

    }

}
