package com.tuf.searching.bs;

public class UpperBound {
    // Smallest index such that arr[index]>k
    public static int getUpperBound(int[] arr, int k) { // TC : O(log2N)
        int low = 0;
        int high = arr.length;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
        System.out.println("Upper Bound   : " + getUpperBound(arr, 4));

    }
}
