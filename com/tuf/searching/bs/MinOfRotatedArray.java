package com.tuf.searching.bs;

public class MinOfRotatedArray {

    public static int getMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1; // eliminate the left side
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;// eliminate the right side
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = { 7, 8, 1, 2, 3, 4, 5, 6 };
        System.out.println("Min In Array    : " + getMin(arr));

    }
}
