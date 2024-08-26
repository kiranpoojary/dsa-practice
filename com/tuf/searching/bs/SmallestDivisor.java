package com.tuf.searching.bs;

import java.util.ArrayList;

public class SmallestDivisor {
    // given an array
    // sum of all ceil(ele/num) give sum<=thresh

    public static int[] getMinMaxOfArray(int[] arr) {
        ArrayList<Integer> ar = new ArrayList<>();
        for (Integer ele : arr) {
            ar.add(ele);
        }
        ar.sort(null);
        int[] ans = { ar.get(0), ar.get(ar.size() - 1) };
        return ans;
    }

    public static int getSmallestDivisorBrute(int[] nums, int threshold) {// TC: O(max*n)
        int[] minmax = getMinMaxOfArray(nums);
        int max = minmax[1];
        for (int i = 1; i <= max; i++) { // O(max)
            int sum = 0;
            for (int j = 0; j < nums.length; j++) { // O(n)
                sum += Math.ceilDiv(nums[j], i);
            }
            if (sum <= threshold)
                return i;
        }
        return -1;
    }

    public static int getSmallestDivisorBS(int[] arr, int thresh) { // O(log2Max)*N ; SC: O(1)
        int[] minmax = getMinMaxOfArray(arr);
        int low = 1;
        int high = minmax[1];
        int finalAns = Integer.MAX_VALUE;
        if (arr.length > thresh)// e.g: 4 ele in arr and 2 thres: then id divisor 1 also give at least 4
            return -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                ans += Math.ceilDiv(arr[i], mid);
            }
            if (ans <= thresh) {
                if (finalAns > mid) {// finalAns = Math.min(finalAns, mid);
                    finalAns = mid;
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return finalAns; // retun low as well
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 9 };
        System.out.println("Smallest Divisor Brute     : " + getSmallestDivisorBrute(arr, 8));
        System.out.println("Smallest Divisor BS        : " + getSmallestDivisorBS(arr, 8));
    }
}
