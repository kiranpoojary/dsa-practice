package com.tuf.searching.bs;

public class BinarySearch {
    public static int doBinarySearch(int[] arr, int k) { // O(lof2N) ; SC: O(1)
        int low = 0;
        int high = arr.length;
        int found = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                found = mid;
                break;
            } else {
                if (k < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return found;
    }

    public static int doBinarySearchRecursively(int[] arr, int low, int high, int k) { // O(lof2N) ; SC: O(1)
        int mid = (low + high) / 2;
        if (low > high)
            return -1;
        if (arr[mid] == k)
            return mid;
        if (k < arr[mid]) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
        mid = (low + high) / 2;
        return doBinarySearchRecursively(arr, low, high, k);
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
        System.out.println("BS Normal     : " + BinarySearch.doBinarySearch(arr, 12));
        System.out.println("BS Recursive  : " + BinarySearch.doBinarySearchRecursively(arr, 0, arr.length - 1, 12));
    }
}
