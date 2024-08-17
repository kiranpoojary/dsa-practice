package com.tuf.arr.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public void nextPermutationBrute(int[] arr) { // O(nlogn)+O(nlogn)
        // sort array: O(nlogn)
        // search for given permutation O(nlogn) with binary search
        // pick the next after search result if its at n-1 then pick 0
    }

    public List<Integer> nextPermutationOptimal(List<Integer> arr) { // TC: O(3n)
        int fallIndex = -1;
        int n = arr.size();
        for (int i = n - 2; i >= 0; i--) { // TC: O(n)
            if (arr.get(i) < arr.get(i + 1)) {
                fallIndex = i;
                break;
            }
        }
        if (fallIndex == -1) {
            Collections.reverse(arr);
            return arr;
        }

        for (int i = n - 1; i > fallIndex; i--) { // TC: O(n)
            if (arr.get(i) > arr.get(fallIndex)) {
                Collections.swap(arr, fallIndex, i);
                break;
            }
        }

        int left = fallIndex + 1;
        int right = n - 1;
        while (left < right) { // TC: O(n)
            int temp = arr.get(left);
            arr.set(left, arr.get(right));
            arr.set(right, temp);
            ++left;
            --right;
        }

        return arr;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(2, 1, 5, 4, 3, 0, 0));
        NextPermutation n = new NextPermutation();
        System.out.println("n.nextPermutationOptimal(arr) :" + n.nextPermutationOptimal(arr));
    }
}
