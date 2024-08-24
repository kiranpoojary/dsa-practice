package com.tuf.searching.bs;

public class InsertionIndex {
    // insertion index is nthing but lowerBound
    public static int getLowerBound(int[] arr, int k) { // TC : O(log2N)
        int low = 0;
        int high = arr.length - 1;
        int inx = arr[high];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= k) {
                inx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return inx;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
        System.out.println("Lower Bound  : " + getLowerBound(arr, 6));
    }
}
