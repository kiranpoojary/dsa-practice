package com.tuf.arr.hard;

import java.util.HashMap;
import java.util.Map;

public class XorSubArraySumCount {

    public int getXorSubArraySumCountBrute(int[] arr, int targetSum) { // O(n3)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum ^ arr[k];
                }
                if (sum == targetSum)
                    ++count;
            }
        }
        return count;
    }

    public int getXorSubArraySumCountBetter(int[] arr, int targetSum) { // O(n^2)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum ^ arr[j];
                if (sum == targetSum)
                    ++count;
            }
        }
        return count;

    }

    public int getXorSubArraySumCountOptimal(int[] arr, int targetSum) { // TC: O(n) SC: O(n) for map mp
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        int prevXOR = 0;
        int allXOR = 0;
        mp.put(allXOR, 1);
        for (int i = 0; i < arr.length; i++) {
            allXOR = allXOR ^ arr[i];
            int prevRemove = allXOR ^ targetSum;
            if (mp.containsKey(prevRemove)) {
                count += mp.get(prevRemove);
            }
            if (mp.containsKey(allXOR)) {
                mp.put(allXOR, (mp.get(allXOR) + 1));
            } else {
                mp.put(allXOR, 1);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 6, 4 };
        XorSubArraySumCount x = new XorSubArraySumCount();
        System.out.println("Brute   :" + x.getXorSubArraySumCountBrute(arr, 6));
        System.out.println("Better  :" + x.getXorSubArraySumCountBetter(arr, 6));
        System.out.println("Optimal :" + x.getXorSubArraySumCountOptimal(arr, 6));
    }
}
