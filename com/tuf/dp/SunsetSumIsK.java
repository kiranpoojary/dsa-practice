package com.tuf.dp;

import java.util.Arrays;

public class SunsetSumIsK {

    public static boolean hasSubsetTargetSumRecursive(int[] arr, int idx, int target) {
        if (target == 0)
            return true;// already reached by prev recursion
        if (idx == 0)
            return arr[idx] == target;
        boolean notTaken = hasSubsetTargetSumRecursive(arr, idx - 1, target);
        boolean taken = false;
        taken = hasSubsetTargetSumRecursive(arr, idx - 1, target - arr[idx]);
        return (taken || notTaken);
    }

    // *************************

    public static boolean hasSubsetTargetSumMemo(int[] arr, int idx, int target, boolean[][] memo) {
        if (target == 0)
            return true;// already reached by prev recursion
        if (idx == 0)
            return arr[idx] == target;
        if (memo[idx][target]) {
            System.out.println("-----");
            return true;
        }
        boolean notTaken = hasSubsetTargetSumMemo(arr, idx - 1, target, memo);
        boolean taken = false;
        taken = hasSubsetTargetSumMemo(arr, idx - 1, target - arr[idx], memo);
        memo[idx][target] = (memo[idx][target] || (taken || notTaken));
        return memo[idx][target];
    }

    public static boolean hasSubsetTargetSumMemoStart(int[] arr, int target) {
        boolean memo[][] = new boolean[target + 1][target + 1];

        return hasSubsetTargetSumMemo(arr, arr.length - 1, target, memo);
    }

    // **************************

    public static boolean hasSubsetTargetSumTabualation(int[] arr, int target) {
        int n = arr.length;
        // Create a boolean DP table with dimensions [n][k+1]
        boolean dp[][] = new boolean[n][target + 1];

        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int k = 1; k <= target; k++) {
                // Calculate if the current target can be achieved without taking the current
                // element
                boolean notTaken = dp[ind - 1][target];

                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }

                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }

        // The final result is stored in the bottom-right cell of the DP table
        return dp[n - 1][target];
    }

    // **************************

    public static boolean hasSubsetTargetSumSpaceOpti(int[] arr, int target) {
        int n = arr.length;
        // Create an array to store the previous row of the DP table
        boolean prev[] = new boolean[target + 1];

        // Initialize the first row of the DP table
        prev[0] = true;

        // Initialize the first column of the DP table
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store the current row of the DP table
            boolean cur[] = new boolean[target + 1];

            // Initialize the first column of the current row
            cur[0] = true;

            for (int k = 1; k <= target; k++) {
                // Calculate if the current target can be achieved without taking the current
                // element
                boolean notTaken = prev[target];

                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = prev[target - arr[ind]];
                }

                // Store the result in the current row of the DP table
                cur[target] = notTaken || taken;
            }

            // Update the previous row with the current row
            prev = cur;
        }

        // The final result is stored in the last cell of the previous row
        return prev[target];
    }

    // **************************
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println("Subset sum(recursive)       :" + hasSubsetTargetSumRecursive(arr, arr.length - 1, 4));
        System.out.println("Subset sum(recu-memo)       :" + hasSubsetTargetSumRecursive(arr, arr.length - 1, 4));
        System.out.println("Subset sum(tabualtion)      :" + hasSubsetTargetSumTabualation(arr, 4));
        System.out.println("Subset sum(space-opti)      :" + hasSubsetTargetSumSpaceOpti(arr, 4));
    }
}
