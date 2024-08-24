package com.tuf.searching.bs;

public class CountOccr {
    public static int getLowerBound(int[] arr, int k) { // TC : O(log2N)
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    public static int getUpperBound(int[] arr, int k) { // TC : O(log2N)
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
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

    public static int getCount(int[] arr, int x) {
        // count = (lastOccurIndex-firstOccurIndex+1)
        // firstOccurIndex is LB
        // lastOccurIndex is ub-1 : but our formula has +1 so ub-1+1 = ub only hence
        // ub-lb;
        int lb = getLowerBound(arr, x);
        int ub = getUpperBound(arr, x);
        if (lb == -1) // -1 means not found
            return 0;
        else
            return ub - lb; // here we are not added 1 because we need last occurence of x which is
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13, 13 };
        System.out.println("Count  : " + getCount(arr, 8));

    }
}
