package com.tuf.arr.hard;

import java.util.Arrays;
import java.util.Comparator;

public class MergeTwoSortedArray {

    public static void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }

    private static void mergeArrayWithExtraSpaceBrute(int[] arr1, int[] arr2) { // TC: O(2(m+n)) SC: O(m+n)
        int m = arr1.length;
        int n = arr2.length;
        int[] ansArray = new int[m + n];
        int idx = 0;
        int left = 0;
        int right = 0;
        while (left < m && right < n) {
            if (arr1[left] < arr2[right]) {
                ansArray[idx++] = arr1[left];
                ++left;
            } else {
                ansArray[idx++] = arr2[right];
                ++right;
            }
        }

        while (left < m) {
            ansArray[idx++] = arr1[left++];
        }

        while (right < n) {
            ansArray[idx++] = arr2[right++];
        }
        // for (int i : ansArray) {
        // System.out.print(i + " ");
        // }
        for (int i = 0; i < ansArray.length; i++) {
            if (i < m) {
                arr1[i] = ansArray[i];
            } else {
                arr2[i - m] = ansArray[i];
            }
        }

    }

    private static void mergeArrayWithoutExtraSpaceOptimalOne(int[] arr1, int[] arr2) { // TC:
                                                                                        // O(min(m,n))+O(mlogm)+O(nlogn)
                                                                                        // SC: O(1)
        // O(1)
        int m = arr1.length;
        int n = arr2.length;
        int leftArrPtr = m - 1;
        int rightArrPtr = 0;
        while (leftArrPtr >= 0 && rightArrPtr < n) {
            if (arr1[leftArrPtr] > arr2[rightArrPtr]) {
                int temp = arr1[leftArrPtr];
                arr1[leftArrPtr] = arr2[rightArrPtr];
                arr2[rightArrPtr] = temp;
                --leftArrPtr;
                ++rightArrPtr;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }

    private void mergeArrayWithoutExtraSpaceOptimalTwo(int[] arr1, int[] arr2) { // TC: OO(logn(m+n))+O(m+n) ; SC: O(1)
        int m = arr1.length;
        int n = arr2.length;
        int len = (m + n);
        int gap = Math.ceilDiv(len, 2);
        while (gap > 0) { // TC: O(logn(m+n))
            int left = 0;
            int right = left + gap;
            while (right < len) { // TC O(m+n)
                // case 1: left in arr1[]
                // and right in arr2[]:
                if (left < m && right >= m) {
                    this.swapIfGreater(arr1, arr2, left, right - m);
                }
                // case 2: both pointers in arr2[]:
                else if (left >= m) {
                    this.swapIfGreater(arr2, arr2, left - m, right - m);

                }
                // case 3: both pointers in arr1[]:
                else {
                    swapIfGreater(arr1, arr1, left, right);

                }
                ++left;
                ++right;
            }

            if (gap == 1)
                break;
            gap = Math.ceilDiv(gap, 2);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 5, 7, 9 };
        int[] arr2 = { 1, 2, 4, 6, 7, 8 };
        MergeTwoSortedArray m = new MergeTwoSortedArray();
        m.mergeArrayWithExtraSpaceBrute(arr1, arr2);

        for (int i : arr1) {
            System.out.print(i + " ");
        }
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println("\n----------------------");

        int[] arr3 = { 1, 3, 5, 7, 9 };
        int[] arr4 = { 1, 2, 4, 6, 7, 8 };
        m.mergeArrayWithoutExtraSpaceOptimalOne(arr3, arr4);
        for (int i : arr3) {
            System.out.print(i + " ");
        }
        for (int i : arr4) {
            System.out.print(i + " ");
        }
        System.out.println("\n----------------------");

        int[] arr5 = { 1, 3, 5, 7 };
        int[] arr6 = { 0, 2, 6, 8, 9 };

        m.mergeArrayWithoutExtraSpaceOptimalTwo(arr5, arr6);
        for (int i : arr5) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : arr6) {
            System.out.print(i + " ");
        }
    }

}
