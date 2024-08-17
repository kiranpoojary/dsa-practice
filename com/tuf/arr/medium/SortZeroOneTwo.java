package com.tuf.arr.medium;

public class SortZeroOneTwo {

    public void sortBrute(int[] arr) {
        // brute method: O(nlogn) with merge sort
    }

    public void sortBetter(int[] arr) { // O(2n)
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    ++zeroCount;
                    break;
                case 1:
                    ++oneCount;
                    break;
                case 02:
                    ++twoCount;
                    break;
                default:
                    break;
            }

        }

        for (int j = 0; j < zeroCount; j++) {
            arr[j] = 0;
        }
        for (int j = zeroCount; j < (zeroCount + oneCount); j++) {
            arr[j] = 1;
        }

        for (int j = (zeroCount + oneCount); j < arr.length; j++) {
            arr[j] = 2;
        }
    }

    public void sortOptimal(int[] arr) { // O(n)
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                ++low;
                ++mid;
            } else if (arr[mid] == 1) {
                ++mid;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                --high;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] - arr[j];
        arr[j] = arr[i] + arr[j];
        arr[i] = arr[j] - arr[i];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 2, 2, 1, 0, 2, 1, 0, 0, 1, 2, 1, 0 };
        SortZeroOneTwo s = new SortZeroOneTwo();
        // s.sortBetter(arr);
        // for (int i : arr) {
        // System.out.print(i + " ");
        // }

        int[] arr2 = { 1, 0, 1, 2, 2, 1, 0, 2, 1, 0, 0, 1, 2, 1, 0 };
        s.sortOptimal(arr2);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}
