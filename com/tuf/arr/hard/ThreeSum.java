package com.tuf.arr.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.youtube.com/watch?v=DhFh8Kw7ymk&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=36

public class ThreeSum {

    public Set<ArrayList<Integer>> getThreeSumBrute(int[] arr, int sum) { // TC: O(n^3)+O(log no. of unique sets)
        Set<ArrayList<Integer>> st = new HashSet<ArrayList<Integer>>(); // SC: 2*O(No. of triplets)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if ((arr[i] + arr[j] + arr[k]) == sum) {
                        ArrayList<Integer> threeElements = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k]));
                        threeElements.sort(null); // TC: O(2) means constant(ignore)
                        st.add(threeElements);
                    }

                }
            }
        }
        return st;
    }

    public Set<ArrayList<Integer>> getThreeSumBetter(int[] arr, int sum) { // TC: O(n^2) + O(log set size) SC:
                                                                           // O(n)+O(unique triplets)
        Set<ArrayList<Integer>> st = new HashSet<ArrayList<Integer>>();
        Set<Integer> middleEles = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int thirdRequiredEle = sum - arr[i] - arr[j];// sum=a+b+c so c=sum-a-b
                if (middleEles.contains(thirdRequiredEle)) { // TC: O(log M) M= set size
                    ArrayList<Integer> triplet = new ArrayList<>(Arrays.asList(arr[i], arr[j], thirdRequiredEle));
                    triplet.sort(null);
                    st.add(triplet);
                    middleEles.clear();
                    break;
                } else {
                    middleEles.add(arr[j]);
                }

            }
        }
        return st;
    }

    public Set<ArrayList<Integer>> getThreeSumOptimal(int[] arr, int sum) { // TC: O(n^2)+O(nlogn) ; SC: O(No. of unique
                                                                            // triplets)
        Set<ArrayList<Integer>> ans = new HashSet<ArrayList<Integer>>();
        List<Integer> arrList = new ArrayList<Integer>();
        for (int ele : arr) {
            arrList.add(ele);
        }
        arrList.sort(null); // TC: O(nlogn)

        for (int i = 0; i < arrList.size(); i++) { // TC: O(n)
            if (i > 0 && arrList.get(i).equals(arrList.get(i - 1)))
                continue;
            int j = i + 1;
            int k = arrList.size() - 1;
            while (j < k) {
                int tripletSum = arrList.get(i) + arrList.get(j) + arrList.get(k);
                if (tripletSum < sum)
                    ++j;
                else if (tripletSum > sum)
                    --k;
                else { // equal
                    ArrayList<Integer> tripletArr = new ArrayList<>(
                            Arrays.asList(arrList.get(i), arrList.get(j), arrList.get(k)));
                    ans.add(tripletArr);
                    ++j;
                    --k;
                    while (j < k && arrList.get(j).equals(arrList.get(j - 1)))
                        ++j;
                    while (j < k && arrList.get(k).equals(arrList.get(k + 1)))
                        --k;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println(t.getThreeSumBrute(arr, 0));
        System.out.println(t.getThreeSumBetter(arr, 0));
        System.out.println(t.getThreeSumOptimal(arr, 0));
    }
}
