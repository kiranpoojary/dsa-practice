package com.tuf.arr.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {

    public Set<ArrayList<Integer>> getFourSumElesBrute(int[] arr, int sum) {// TC: O(n^4) SC: O(No. quads)*2
        Set<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>(); // O(No. quads)*2
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        int fourSum = arr[i] + arr[j] + arr[k] + arr[l];
                        if (fourSum == sum) {
                            ArrayList<Integer> arl = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], arr[l]));
                            arl.sort(null);
                            ans.add(arl);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public Set<ArrayList<Integer>> getFourSumElesBetter(int[] arr, int sum) { // TC: O(n^3)+O(M) M is dynamic for No.
                                                                              // ele in set SC: O(n)+O(unique quads)*2
        Set<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Set<Integer> middleEls = new HashSet<>();
                for (int k = j + 1; k < arr.length; k++) {
                    int fourthEle = sum - arr[i] - arr[j] - arr[k]; // sum=a+b+c+d;
                    if (middleEls.contains(fourthEle)) { // TC: O(M)
                        ArrayList<Integer> arl = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k], fourthEle));
                        arl.sort(null);
                        ans.add(arl);
                    } else {
                        middleEls.add(arr[k]);
                    }
                }
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, -1, 0, -2, 2 };
        FourSum f = new FourSum();
        System.out.println(f.getFourSumElesBrute(arr, 2));
        System.out.println(f.getFourSumElesBetter(arr, 2));
    }
}
