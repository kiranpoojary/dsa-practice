package com.tuf.searching.bs;

public class CountTotalRotation {

    // When you rotate a sorted array three times to the right, the elements move to
    // the right, with the last elements wrapping around to the front. Here’s how
    // the array [1, 2, 3, 4, 5] looks after each of the three rotations:

    // First rotation (1 element moved to the front):

    // Original: [1, 2, 3, 4, 5]
    // After 1st rotation: [5, 1, 2, 3, 4]
    // Second rotation (2 elements moved to the front):

    // After 2nd rotation: [4, 5, 1, 2, 3]
    // Third rotation (3 elements moved to the front):

    // After 3rd rotation: [3, 4, 5, 1, 2]
    // So, the array [1, 2, 3, 4, 5] rotated three times results in [3, 4, 5, 1, 2].

    // Number of rotations = Index of the minimum element = 3.

    public static int getMinValueIndex(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    ans = arr[low];
                }
                break;
            }
            if (arr[low] <= arr[mid]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                low = mid + 1;
            } else {
                high = mid - 1;
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 6, 7, 8, 1, 2, 3, 4, 5 };
        System.out.println("Total Rotation made   : " + getMinValueIndex(arr));
    }
}
