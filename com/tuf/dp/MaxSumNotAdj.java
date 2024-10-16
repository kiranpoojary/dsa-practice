package com.tuf.dp;

import java.util.Arrays;

public class MaxSumNotAdj {
    // return max sum by adding all non-adj elements

    public static int maxSumRecursive(int idx, int[] arr) {
        if (idx == 0)
            return arr[0];
        if (idx < 0)
            return 0;
        int pick = arr[idx] + maxSumRecursive(idx - 2, arr);
        int notPick = 0 + maxSumRecursive(idx - 1, arr);
        return Math.max(pick, notPick);
    }

    public static int maxSumMemo(int idx, int[] arr, int[] memo) {
        if (idx == 0)
            return arr[0];
        if (idx < 0)
            return 0;
        if (memo[idx] != -1)
            return memo[idx];
        int pick = arr[idx] + maxSumMemo(idx - 2, arr, memo);
        int notPick = 0 + maxSumMemo(idx - 1, arr, memo);
        memo[idx] = Math.max(pick, notPick);
        return memo[idx];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9 };
        int[] memo = new int[arr.length + 1];
        Arrays.fill(memo, -1);
        System.out.println("Max non adjecent sum   :" + maxSumRecursive(arr.length - 1, arr));
        System.out.println("Max non adjecent sum   :" + maxSumMemo(arr.length - 1, arr, memo));
    }
}
