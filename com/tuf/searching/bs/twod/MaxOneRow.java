package com.tuf.searching.bs.twod;

public class MaxOneRow {

    // Smallest index such that arr[index]>k
    public static int getUpperBound(int[] arr, int k) { // TC : O(log2N)
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int getMaxOneRow(int[][] arr) {
        int maxCount = 0;
        int maxOneRowIndex = -1;
        int m = arr.length;
        int n = arr[0].length;
        for (int i = 0; i < arr.length; i++) {
            int firstIndexOfOne = getUpperBound(arr[i], 0);
            int totalOnesCount = (firstIndexOfOne == n) ? 0 : n - firstIndexOfOne;
            if (maxCount < totalOnesCount) {
                maxCount = totalOnesCount;
                maxOneRowIndex = i;
            }
        }
        return maxOneRowIndex;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1 }
        };
        // brute: 2 for loops and traverse each ele, keep index of row with max 1
        System.out.println("Max 1's Row Index BS   :" + getMaxOneRow(arr));
    }
}
