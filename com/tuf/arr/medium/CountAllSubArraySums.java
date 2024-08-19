package com.tuf.arr.medium;

import java.util.HashMap;
import java.util.Map;

// https://www.youtube.com/watch?v=xvNwoz-ufXA&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=33

public class CountAllSubArraySums {
    public int getTotalSubArraySumsBrute(int[] arr, int sum) { // TC: O(n^3)
        int totalSubArrays = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int currSum = 0;
                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }
                if (currSum == sum)
                    totalSubArrays++;
            }
        }
        return totalSubArrays;
    }

    public int getTotalSubArraySumsBetter(int[] arr, int sum) { // TC: O(n^2)
        int totalSubArrays = 0;
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == sum) {
                    totalSubArrays++;
                }
            }
        }
        return totalSubArrays;
    }

    public int getTotalSubArraySumsOptimal(int[] arr, int sum) { // TC: O(n) SC: O(n)
        Map<Integer, Integer> mp = new HashMap<>(); // SC: O(n)
        mp.put(0, 1);
        int totalSubArrays = 0;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) { // TC: O(n)
            prefixSum += arr[i];
            int removePrev = prefixSum - sum;
            if (mp.containsKey(removePrev)) {
                totalSubArrays += mp.get(removePrev);
                if (mp.containsKey(prefixSum)) {
                    mp.put(prefixSum, (mp.get(prefixSum) + 1));
                } else {
                    mp.put(prefixSum, 1);
                }
            } else {
                mp.put(prefixSum, 1);
            }
        }
        System.out.println(mp);
        return totalSubArrays;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 4, -2, 1, -4 };
        CountAllSubArraySums c = new CountAllSubArraySums();
        System.out.println("getTotalSubArraySumsBrute : " +
                c.getTotalSubArraySumsBrute(arr, 7));
        System.out.println("getTotalSubArraySumsBetter : " +
                c.getTotalSubArraySumsBetter(arr, 7));
        System.out.println("------------ OPTIMAL-----------------");
        System.out.println("getTotalSubArraySumsOptimal  : " + c.getTotalSubArraySumsOptimal(arr, 7));

    }
}
