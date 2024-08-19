package com.tuf.arr.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// https://www.youtube.com/watch?v=vwZj1K0e9U8&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=35
import java.util.Set;

public class MajorityElementNByThree {
    // Rule the mejority of by 2(n/2) can have at most 2 majority

    public List<Integer> getMajorityByThreeBrute(int[] arr) { // TC : O(n^2) SC: O(1)
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if (!ans.contains(arr[i])) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j])
                        count++;
                }
            }
            if (count > Math.floor((double) arr.length / 3)) {
                ans.add(arr[i]);
            }

            if (ans.size() == 2)
                break; // majority element of n/3 can have at most 2 majority element in it
        }

        return ans;

    }

    public List<Integer> getMajorityByThreeBetter(int[] arr) { // TC : O(n) + O(logn) ; SC: O(n)
        List<Integer> ans = new ArrayList<>();
        try {
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < arr.length; i++) { // TC : O(n)
                if (!mp.containsKey(arr[i])) { // not already in map
                    mp.put(arr[i], 1);
                } else {
                    if (!ans.contains(arr[i])) { // not already added to ans
                        int newCount = mp.get(arr[i]) + 1; // TC : O(logn)
                        if (newCount > Math.floor((double) arr.length / 3)) {
                            ans.add(arr[i]);
                            mp.put(arr[i], newCount);
                        } else {
                            mp.put(arr[i], newCount);
                        }
                        if (ans.size() == 2)
                            break;
                    }

                }
            }
            return ans;
        } catch (Exception e) {
            System.out.println(e);
            return ans;
        }

    }

    public List<Integer> getMajorityByThreeOptimal(int[] arr) { // TC : O(2n) SC: O(1)
        int ele1 = 0;
        int cnt1 = 0;
        int ele2 = 0;
        int cnt2 = 0;

        for (int i = 0; i < arr.length; i++) { // TC : O(n)
            if (cnt1 == 0 && arr[i] != ele2) {
                ele1 = arr[i];
                cnt1++;
            } else if (cnt2 == 0 && arr[i] != ele1) {
                ele2 = arr[i];
                cnt2++;
            } else if (arr[i] == ele1) {
                cnt1++;
            } else if (arr[i] == ele2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        int ele1Count = 0;
        int ele2Count = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) { // TC : O(n)
            if (arr[i] == ele1)
                ++ele1Count;
            else if (arr[i] == ele2)
                ++ele2Count;
        }

        if (ele1Count > (Math.floor((double) arr.length / 3))) {
            ans.add(ele1);
        }

        if (ele2Count > (Math.floor((double) arr.length / 3))) {
            ans.add(ele2);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 3, 3, 2, 2, 2 };
        MajorityElementNByThree m = new MajorityElementNByThree();
        System.out.println("getMajorityByThreeBrute   :" + m.getMajorityByThreeBrute(arr));
        System.out.println("getMajorityByThreeBetter   :" + m.getMajorityByThreeBetter(arr));
        System.out.println("getMajorityByThreeOptimal   :" + m.getMajorityByThreeOptimal(arr));
    }
}
