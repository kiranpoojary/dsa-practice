package com.tuf.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 4, 7, 9, 3, 6, 24, 8, 19, 5, 1 };
        for (int i = arr.length - 1; i >= 1; i--) {
            boolean sortNotRequired = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    sortNotRequired = false;
                }
            }
            System.out.println("Running....");
            if (sortNotRequired)
                break;

        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
