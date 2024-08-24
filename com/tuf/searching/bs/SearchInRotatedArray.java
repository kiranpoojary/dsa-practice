package com.tuf.searching.bs;

public class SearchInRotatedArray {

    public static int searchInRotatedArray(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x)
                return mid;
            // check sorted side is left
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= x && x <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // else sorted side is right
                if (arr[mid] <= x && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // IMP----$$$$$---- IMP
    public static int searchInRotatedArrayWithDuplicates(int[] arr, int x) {// TC : O(log2n) ATC: O(n/2)
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            // check sorted side is left
            if (arr[low] <= arr[mid]) {
                if (arr[low] <= x && x <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // else sorted side is right
                if (arr[mid] <= x && x <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 11, 13, 14, 2, 4, 6, 8, 9 };
        System.out.println("Found Index  : " + searchInRotatedArray(arr, 1));

        // do the below with without duplicate logic(searchInRotatedArray)
        int[] arr2 = { 3, 1, 2, 3, 3, 3, 3 };
        System.out.println("Found Index dupli(searchInRotatedArray)  : " + searchInRotatedArray(arr2, 1));// not works
                                                                                                          // with dupli
        System.out.println("Found Index WIth Duplicate in Array      : " + searchInRotatedArrayWithDuplicates(arr2, 1));

    }
}
