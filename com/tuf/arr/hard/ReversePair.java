package com.tuf.arr.hard;

import java.util.ArrayList;

public class ReversePair {

    public static int getReversePairBrute(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) { // TC O(n^2) ; O(1)
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > (2 * arr[j]))
                    ++count;
            }
        }
        return count;
    }

    public static int actualLogicFlowByMergeSort(int arr1[], int[] arr2) {
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int currCount = 0;
            for (int j = 0; (j < arr2.length) && (arr1[i] > (2 * arr2[j])); j++) {
                ++currCount;
            }
            count += currCount;
        }
        return count;
    }

    // ------------------------
    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr

        // storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right])
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid); // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += countPairs(arr, low, mid, high); // Modification
        merge(arr, low, mid, high); // merging sorted halves
        return cnt;
    }

    public static int team(int[] arr, int n) { // TC: O(2N*logN) ; SC: O(n)
        return mergeSort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 40, 25, 19, 12, 9, 6, 2 };
        ReversePair r = new ReversePair();
        System.out.println("Brute               : " + r.getReversePairBrute(arr));
        int[] arr1 = { 6, 13, 21, 25 };
        int[] arr2 = { 1, 2, 3, 4, 4, 5, 9, 11, 23 };
        System.out.println("actualLogicFlowByMergeSort    : " + r.actualLogicFlowByMergeSort(arr1, arr2));
        int[] ar = { 4, 1, 2, 3, 1 };
        int cnt = r.team(ar, ar.length);
        System.out.println("Optimal(merge sort) reverse pairs : " + cnt);
    }
}
