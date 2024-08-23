package com.tuf.arr.hard;

public class MaxSubArrayProduct {

    public static int getMaxSubArrayProductBrute(int[] arr) { // TC : )(n^2)
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= arr[k];
                }
                maxProduct = Math.max(maxProduct, prod);
            }
        }
        return maxProduct;
    }

    public static int getMaxSubArrayProductOptimal(int[] arr) { // TC : O(n) ; SC: O(1)
        int n = arr.length;
        int maxProduct = Integer.MIN_VALUE;
        int sufixProduct = 1;
        int prefixProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            if (prefixProduct == 0)
                prefixProduct = 1;
            if (sufixProduct == 0)
                sufixProduct = 1;
            sufixProduct *= arr[i];
            prefixProduct *= arr[n - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, sufixProduct));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, -2, 4 };
        System.out.println("Brute  : " + MaxSubArrayProduct.getMaxSubArrayProductBrute(arr1));
        System.out.println("Brute  : " + MaxSubArrayProduct.getMaxSubArrayProductOptimal(arr1));

    }
}
