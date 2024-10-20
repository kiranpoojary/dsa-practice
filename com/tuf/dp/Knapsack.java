package com.tuf.dp;

import java.util.Arrays;

public class Knapsack {

    public static int getMaxStealValueRecursive(int[] it, int[] wt, int w, int currItemIndex) {
        if (currItemIndex == 0) {
            if (wt[currItemIndex] <= w)
                return it[currItemIndex];
            else
                return 0;
        }
        int notTake = 0 + getMaxStealValueRecursive(it, wt, w, currItemIndex - 1);
        int take = Integer.MIN_VALUE;
        if (wt[currItemIndex] <= w) {
            take = it[currItemIndex] + getMaxStealValueRecursive(it, wt, w - wt[currItemIndex], currItemIndex - 1);
        }
        return Math.max(take, notTake);
    }

    // ***********************

    public static int getMaxStealValueRecursiveMemo(int[] it, int[] wt, int w, int currItemIndex, int[][] memo) {
        if (currItemIndex == 0) {
            if (wt[currItemIndex] <= w)
                return it[currItemIndex];
            else
                return 0;
        }
        if (memo[currItemIndex][w] != -1) {
            return memo[currItemIndex][w];
        }
        int notTake = 0 + getMaxStealValueRecursiveMemo(it, wt, w, currItemIndex - 1, memo);
        int take = Integer.MIN_VALUE;
        if (wt[currItemIndex] <= w) {
            take = it[currItemIndex]
                    + getMaxStealValueRecursiveMemo(it, wt, w - wt[currItemIndex], currItemIndex - 1, memo);
        }
        memo[currItemIndex][w] = Math.max(take, notTake);
        return memo[currItemIndex][w];

    }

    public static int getMaxStealValueRecursiveMemoStart(int[] itemValue, int[] wt, int w, int currItemIndex) {
        int[][] memo = new int[itemValue.length][w + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMaxStealValueRecursiveMemo(itemValue, wt, w, currItemIndex, memo);
    }

    // ***************************

    public static int getMaxStealValueRecursiveTabulation(int[] val, int[] wt, int n, int w) {
        // Create a 2D DP array to store the maximum value for each subproblem
        int dp[][] = new int[n][w + 1];

        // Base Condition
        for (int i = wt[0]; i <= w; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= w; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = dp[ind - 1][cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];
                }

                // Store the maximum value for the current state
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last rowwand last column of the DP array
        return dp[n - 1][w];
    }

    // *************************

    public static int getMaxStealValueRecursiveSpaceOpti(int[] val, int[] wt, int n, int w) {
        // Create an array to store the maximum value for each capacity (previous row)
        int prev[] = new int[w + 1];

        // Base Condition: Initialize the first row of the array
        for (int i = wt[0]; i <= w; i++) {
            prev[i] = val[0];
        }

        // Iterate through each item and capacity
        for (int ind = 1; ind < n; ind++) {
            for (int cap = w; cap >= 0; cap--) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) {
                    taken = val[ind] + prev[cap - wt[ind]];
                }

                // Update the array with the maximum value for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last element of the array
        return prev[w];
    }

    // **********************
    public static void main(String[] args) {
        int[] itemsValue = { 30, 40, 60 };
        int[] itemsWeight = { 3, 2, 5 };
        int bagWeight = 6;

        // for memo entry check
        // int[] itemsValue = { 2, 3, 4, 5, 6, 7, 8, 4, 3, 2 };
        // int[] itemsWeight = { 2, 4, 5, 3, 2, 1, 3, 5, 3, 2 };
        // int bagWeight = 14;

        System.out.println("Max steal value(recu)       :"
                + getMaxStealValueRecursive(itemsValue, itemsWeight, bagWeight, itemsWeight.length - 1));
        System.out.println("Max steal value(memo)       :"
                + getMaxStealValueRecursiveMemoStart(itemsValue, itemsWeight, bagWeight, itemsWeight.length - 1));
        System.out.println("Max steal value(tabu)       :"
                + getMaxStealValueRecursiveTabulation(itemsValue, itemsWeight, itemsWeight.length - 1, bagWeight));
        System.out.println("Max steal value(spac)       :"
                + getMaxStealValueRecursiveSpaceOpti(itemsValue, itemsWeight, itemsWeight.length - 1, bagWeight));
    }
}
