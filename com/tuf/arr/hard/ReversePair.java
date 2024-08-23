package com.tuf.arr.hard;

public class ReversePair {

    public static int getReversePairBrute(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) { // TC O(n^2) ; O(1)
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (2 * arr[j]))
                    ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 40, 25, 19, 12, 9, 6, 2 };
        ReversePair r = new ReversePair();
        System.out.println("Brute    : " + r.getReversePairBrute(arr));
    }
}
