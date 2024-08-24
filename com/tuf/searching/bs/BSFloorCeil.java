package com.tuf.searching.bs;

import java.util.Arrays;

public class BSFloorCeil {
    public static int getFloor(int[] arr, int k) {
        int floor = -1;
        int low = 0;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= k) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }
        return floor;
    }

    public static int getCeil(int[] arr, int k) {
        int ceil = -1;
        int low = 0;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= k) {
                ceil = arr[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return ceil;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 3, 5, 8, 8, 10, 10, 11 };
        System.out.println("Floor   :" + getFloor(arr, 7));
        System.out.println("Ceil    :" + getCeil(arr, 7));
    }
}
