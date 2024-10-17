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

    public static int maxSumTabulation(int[] arr, int[] memo) {
        memo[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += memo[i - 2];
            int notPick = 0 + memo[i - 1];
            memo[i] = Math.max(pick, notPick);
        }
        return memo[arr.length - 1];
    }

    public static int maxSumTabulationSpaceOptimized(int[] arr) {
        int prev = arr[0];
        int prev2 = 0;
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += prev2;
            int notPick = 0 + prev;
            int curi = Math.max(pick, notPick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 4, 9 };
        int[] memo = new int[arr.length + 1];
        Arrays.fill(memo, -1);
        System.out.println("Max non adjecent sum recursive          :" + maxSumRecursive(arr.length - 1, arr));
        System.out.println("Max non adjecent sum meoization         :" + maxSumMemo(arr.length - 1, arr, memo));
        int[] memo2 = new int[arr.length + 1];
        Arrays.fill(memo2, -1);
        System.out.println("Max non adjecent sum tabulation         :" + maxSumTabulation(arr, memo2));
        System.out.println("Max non adjecent sum space optimized    :" + maxSumTabulationSpaceOptimized(arr));

    }
}
