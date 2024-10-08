package com.tuf.recursion;

public class ReverseArray {

    public void swap(int[] arr, int l, int r) {
        if (l >= r)
            return;
        else {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            swap(arr, l + 1, r - 1);
        }
    }

    //
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        ReverseArray r = new ReverseArray();
        r.swap(arr, 0, arr.length - 1);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }

    }
}
