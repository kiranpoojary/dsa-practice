package com.tuf.searching.bs;

public class FindSingleElement {

    public static int getSingleBrute(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                if (arr[i] != arr[i + 1])
                    return arr[i];
            } else if (i == n - 1) {
                if (arr[i] != arr[i - 1])
                    return arr[i];
            } else if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
                return arr[i];
        }
        return Integer.MIN_VALUE;
    }
    // --------------
    // (evenIdx, oddIdx) means ele at left
    // ( oddIdx, evenIdx) means ele at right

    public static int getSingleBSOptimal(int[] arr) {
        int n = arr.length;
        int low = 1;
        int high = n - 2;
        if (n == 1)
            return arr[0];
        else if (arr[0] != arr[1])
            return arr[0];
        else if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];
            else if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            } else
                high = mid - 1;
        }

        return Integer.MIN_VALUE;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7 };
        System.out.println("Single Ele Brute    : " + getSingleBrute(arr));
        System.out.println("Single Ele BS       : " + getSingleBSOptimal(arr));
    }
}
