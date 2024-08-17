package com.tuf.arr.medium;

import java.util.ArrayList;
import java.util.List;

public class AlternateBySign {

    // here both + and - are in same size
    public void alternateNumbersBrute(int[] arr) { // only +ve and -ve number no zeroTC: O(n)+O(n/2); SC:O(n)
        int halfLength = arr.length / 2;
        int[] positives = new int[halfLength];
        int[] negatives = new int[halfLength];
        int indPv = 0;
        int indNv = 0;
        for (int i = 0; i < arr.length; i++) { // O(n)
            if (arr[i] > 0) {
                positives[indPv] = arr[i];
                ++indPv;
            } else {
                negatives[indNv] = arr[i];
                ++indNv;
            }
        }
        for (int i = 0; i < halfLength; i++) { // O(n/2)
            arr[2 * i] = positives[i];
            arr[2 * i + 1] = negatives[i];
        }
    }

    public void alternateNumbersOptimal(int[] arr) {
        int[] ans = new int[arr.length];
        int posIndex = 0;
        int negIndex = 1;
        for (int i = 0; i < arr.length; i++) { // O(n)
            if (arr[i] > 0) {
                ans[posIndex] = arr[i];
                posIndex += 2;
            } else {
                ans[negIndex] = arr[i];
                negIndex += 2;
            }
        }
        for (int ele : ans) {
            System.out.print(ele + " ");
        }
    }

    // here both + and - are in diff size, add remaining at the end
    public void alternateNumbersBruteVarietyTwo(int[] arr) { // O(2n)
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) { // O(n)
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }

        if (pos.size() < neg.size()) {
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int nextFillIndex = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[nextFillIndex] = neg.get(i);
                ++nextFillIndex;
            }
        } else {
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
            }
            int nextFillIndex = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[nextFillIndex] = pos.get(i);
                ++nextFillIndex;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, -3, 4, -4, -1 };
        AlternateBySign a = new AlternateBySign();
        a.alternateNumbersBrute(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr2 = { 1, 5, -3, 4, -4, -1 };
        a.alternateNumbersOptimal(arr2);
        System.out.println();

        int[] arr3 = { 1, 5, -3, 9, 2, 4, -4, -1, 7 };
        a.alternateNumbersBruteVarietyTwo(arr3);
        for (int ele : arr3) {
            System.out.print(ele + " ");
        }
    }
}
