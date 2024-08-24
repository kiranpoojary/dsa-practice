package com.tuf.searching.bs;

public class FirstLastOccr {

    public static String getFirstLastOccrBrute(int[] arr, int x) { // O(n)
        int f = -1;
        int l = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                if (f == -1)
                    f = i;
                l = i;
            }
        }
        return "First and Last Occr Brute : " + f + " and " + l;
    }

    // ----------------------
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

    public static String getFirstLastOccrBoundApproach(int[] arr, int x) {
        int lb = getLowerBound(arr, x);
        int ub = getUpperBound(arr, x);
        if (arr[lb] != x || ub == arr.length) { // ele not found
            return "First and Last Occr Brute : -1 and -1";
        } else
            return "First and Last Occr Bound : " + lb + " and " + (ub - 1);
    }

    // -------------------
    public static String getFirstLastOccrBSApproach(int[] arr, int x) {
        int low = 0, high = arr.length - 1, first = -1, last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] > x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "First and Last Occr BS    : " + first + " and " + last;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 6, 8, 8, 8, 11, 13 };
        System.out.println(getFirstLastOccrBrute(arr, 8));
        System.out.println(getFirstLastOccrBoundApproach(arr, 8));
        System.out.println(getFirstLastOccrBSApproach(arr, 8));

    }
}
