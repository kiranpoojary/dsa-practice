package com.tuf.dp;

import java.util.Arrays;

public class CountSubsetWithSumK {

    public static int getSubsetCountRecursive(int[] arr, int idx, int targetSum) {
        if (targetSum == 0)
            return 1;
        if (idx == 0)
            return (arr[idx] == targetSum) ? 1 : 0; // if both sum == arr[0] then count+1

        int notTake = getSubsetCountRecursive(arr, idx - 1, targetSum);
        int take = 0;
        take = getSubsetCountRecursive(arr, idx - 1, targetSum - arr[idx]);
        return take + notTake;
    }

    // *******************

    public static int getSubsetCountRecursiveMemo(int[] arr, int idx, int targetSum, int[][] memo) {
        if (targetSum == 0)
            return 1;
        if (idx == 0)
            return (arr[idx] == targetSum) ? 1 : 0; // if both sum == arr[0] then count+1
        if (memo[idx][targetSum] != -1) {
            System.out.println("---------");
            return memo[idx][targetSum];
        }
        int notTake = getSubsetCountRecursive(arr, idx - 1, targetSum);
        int take = 0;
        take = getSubsetCountRecursive(arr, idx - 1, targetSum - arr[idx]);
        memo[idx][targetSum] = take + notTake;
        return take + notTake;
    }

    public static int getSubsetCountRecursiveMemoStart(int[] arr, int n, int target) {
        int[][] memo = new int[n][target + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getSubsetCountRecursiveMemo(arr, n - 1, target, memo);
    }

    // *******************

    public static int getSubsetCountRecursiveTabulation(int[] num, int k) {
        int n = num.length;

        // Create a 2D DP array to store the number of ways to achieve each target sum
        int[][] dp = new int[n][k + 1];

        // Initialize the first row of the DP array
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        // Initialize the first column of the DP array
        if (num[0] <= k) {
            dp[0][num[0]] = 1;
        }

        // Fill in the DP array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate the number of ways when the current element is not taken
                int notTaken = dp[ind - 1][target];

                // Calculate the number of ways when the current element is taken
                int taken = 0;
                if (num[ind] <= target) {
                    taken = dp[ind - 1][target - num[ind]];
                }

                // Update the DP array for the current element and target sum
                dp[ind][target] = notTaken + taken;
            }
        }

        // The result is stored in the last cell of the DP array
        return dp[n - 1][k];
    }

    // *******************
    public static int getSubsetCountRecursiveSpaceOpti(int[] num, int k) {
        int n = num.length;

        // Create an array to store the number of ways to achieve each target sum
        int[] prev = new int[k + 1];

        // Initialize the first element of the array
        prev[0] = 1;

        // Initialize the array for the first column
        if (num[0] <= k) {
            prev[num[0]] = 1;
        }

        // Fill in the array using bottom-up dynamic programming
        for (int ind = 1; ind < n; ind++) {
            // Create an array to store the number of ways for the current element
            int[] cur = new int[k + 1];

            // Initialize the first element of the current array
            cur[0] = 1;

            for (int target = 1; target <= k; target++) {
                // Calculate the number of ways when the current element is not taken
                int notTaken = prev[target];

                // Calculate the number of ways when the current element is taken
                int taken = 0;
                if (num[ind] <= target) {
                    taken = prev[target - num[ind]];
                }

                // Update the current array for the current element and target sum
                cur[target] = notTaken + taken;
            }

            // Update the previous array with the current array for the next iteration
            prev = cur;
        }

        // The result is stored in the last element of the array
        return prev[k];
    }

    // *******************
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3 };
        int K = 3;
        System.out.println("Count subset with K sum(recu)              :" +
                getSubsetCountRecursive(arr, arr.length - 1, K));
        System.out.println(
                "Count subset count with K sum(memo)        :" + getSubsetCountRecursiveMemoStart(arr, arr.length, K));
        System.out.println(
                "Count subset count with K sum(tabu)        :" + getSubsetCountRecursiveTabulation(arr, K));
        System.out.println(
                "Count subset count with K sum(spac)        :" + getSubsetCountRecursiveSpaceOpti(arr, K));
    }
}
