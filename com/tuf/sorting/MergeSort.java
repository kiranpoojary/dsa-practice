package com.tuf.sorting;

import java.util.ArrayList;

public class MergeSort {

    public void mergeSortingDevider(int[] arr, int low, int high) {
        if (low == high) {
            return;
        } else {
            int mid = (low + high) / 2;
            mergeSortingDevider(arr, low, mid);
            mergeSortingDevider(arr, mid + 1, high);
            mergeSortingMerger(arr, low, mid, high);
        }

    }

    public void mergeSortingMerger(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                ++left;
            } else {
                temp.add(arr[right]);
                ++right;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            ++left;
        }

        while (right <= high) {
            temp.add(arr[right]);
            ++right;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = { 4, 7, 9, 3, 6, 24, 8, 19, 5, 1 };
        sort.mergeSortingDevider(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
