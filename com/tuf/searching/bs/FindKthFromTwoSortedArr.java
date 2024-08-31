package com.tuf.searching.bs;

public class FindKthFromTwoSortedArr {
    public static double getKthElementOptimalBS(int[] a, int[] b, int n1, int n2, int k) {
        // Refer 2 sorted array mean first and also for brute and better
        if (n1 > n2)
            return getKthElementOptimalBS(b, a, n2, n1, k);
        int low = Integer.max(k - n2, 0);
        int high = Integer.min(k, n1);
        int left = k;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < n1)
                r1 = a[mid1];
            if (mid2 < n2)
                r2 = b[mid2];
            if (mid1 - 1 >= 0)
                l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0)
                l2 = b[mid2 - 1];

            if (l1 < r2 && l2 < r1) {
                return Math.max(l1, l2);

            } else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 5, 7, 8, 10 };
        int[] arr2 = { 1, 3, 6, 14 };
        System.out.println("Kth ele of 2 Sorted Array :" + getKthElementOptimalBS(arr1, arr2, 6, 4, 4));

    }

}
