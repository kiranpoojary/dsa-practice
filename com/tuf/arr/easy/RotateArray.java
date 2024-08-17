package com.tuf.arr.easy;

public class RotateArray {

    public void leftRotateByOnePlace(int[] arr) {
        int tmp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = tmp;
    }

    public void leftRotateByKPlace(int[] arr, int k) {
        k = k % arr.length;
        int[] temp = new int[k];
        // store rotating ele in temp[]
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        // move remaining ele to top index
        for (int i = 0; i < arr.length - k; i++) {
            arr[i] = arr[k + i];
        }

        // add temp to tail
        int j = 0;
        for (int i = arr.length - k; i < arr.length; i++) {
            arr[i] = temp[j];
            ++j;
        }

    }

    public void leftRotateByKPlaceOptimal(int[] arr, int k) {
        k = k % arr.length;
        this.arrayReverse(arr, 0, k - 1);
        this.arrayReverse(arr, k, arr.length - 1);
        this.arrayReverse(arr, 0, arr.length - 1);

    }

    public void arrayReverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++start;
            --end;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 5, 7, 9, 0, 3, 6, 2, 4 };
        int[] arr2 = { 5, 7, 9, 0, 3, 6, 2, 4 };
        int[] arr3 = { 5, 7, 9, 0, 3, 6, 2, 4 };
        RotateArray ro = new RotateArray();
        ro.leftRotateByOnePlace(arr1);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
        ro.leftRotateByKPlace(arr2, 3);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();
        ro.leftRotateByKPlace(arr3, 3);
        for (int i : arr3) {
            System.out.print(i + " ");
        }
    }
}
