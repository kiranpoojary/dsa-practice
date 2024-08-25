package com.tuf.searching.bs;

import java.util.ArrayList;
import java.util.List;

public class PeakElement {

    // for one peak in array
    public static int getPeakElementBrute(int[] arr) { // TC: O(n) SC: O(1 )
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            // Checking for the peak:
            if ((i == 0 || arr[i - 1] < arr[i])
                    && (i == n - 1 || arr[i] > arr[i + 1])) {
                return arr[i];
            }
        }
        return -1; // Dummy return statement
    }

    // for one peak in array
    public static int getPeakElementSingleBS(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0]; // 0 if index
        if (arr[0] > arr[1])
            return arr[0]; // 0 if index
        if (arr[n - 1] > arr[n - 2])
            return arr[n - 1]; // n-1 if index
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return arr[mid]; // mid if index

            } else {
                if (arr[mid] < arr[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return Integer.MIN_VALUE;
    }

    // for multiple peak in array; slight change to single peak
    // Need to fix
    public static ArrayList<Integer> getPeakElementMultipleBS(int[] arr) {
        ArrayList<Integer> peaks = new ArrayList<>();
        int n = arr.length;

        // Check the first and last elements
        if (n == 1 || arr[0] > arr[1]) {
            peaks.add(arr[0]); // 0th index
        }
        if (arr[n - 1] > arr[n - 2]) {
            peaks.add(arr[n - 1]); // n-1th index
        }

        int low = 1;
        int high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid is a peak
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                peaks.add(arr[mid]);
            }

            // Check for potential peaks in the left and right halves
            if (arr[mid - 1] < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return peaks;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 };
        System.out.println("Find peak index          : " + getPeakElementBrute(arr));
        System.out.println("Single peak index BS     : " + getPeakElementSingleBS(arr));

        int[] arr2 = { 1, 3, 7, 1, 2, 6, 3, 2, 1 };
        System.out.println("Multipl peak index BS    : " + getPeakElementMultipleBS(arr2));
    }

}
