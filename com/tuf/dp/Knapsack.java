package com.tuf.dp;

import java.util.Arrays;

public class Knapsack {

    public static int getMaxStealValueRecursive(int[] itValues, int[] itWeights, int bagWeight, int currItemIndex) {
        if (currItemIndex == 0) {
            if (itWeights[currItemIndex] <= bagWeight)
                return itValues[currItemIndex];
            else
                return 0;
        }
        int notTake = 0 + getMaxStealValueRecursive(itValues, itWeights, bagWeight, currItemIndex - 1);
        int take = Integer.MIN_VALUE; //// MIN when max required
        if (itWeights[currItemIndex] <= bagWeight) {
            take = itValues[currItemIndex]
                    + getMaxStealValueRecursive(itValues, itWeights, bagWeight - itWeights[currItemIndex],
                            currItemIndex - 1);
        }
        return Math.max(take, notTake);
    }

    // ***********************

    public static int getMaxStealValueRecursiveMemo(int[] itValues, int[] itWeights, int bagWeight, int currItemIndex,
            int[][] memo) {
        if (currItemIndex == 0) {
            if (itWeights[currItemIndex] <= bagWeight)
                return itValues[currItemIndex];
            else
                return 0;
        }
        if (memo[currItemIndex][bagWeight] != -1) {
            return memo[currItemIndex][bagWeight];
        }
        int notTake = 0 + getMaxStealValueRecursiveMemo(itValues, itWeights, bagWeight, currItemIndex - 1, memo);
        int take = Integer.MIN_VALUE;
        if (itWeights[currItemIndex] <= bagWeight) {
            take = itValues[currItemIndex]
                    + getMaxStealValueRecursiveMemo(itValues, itWeights, bagWeight - itWeights[currItemIndex],
                            currItemIndex - 1, memo);
        }
        memo[currItemIndex][bagWeight] = Math.max(take, notTake);
        return memo[currItemIndex][bagWeight];

    }

    public static int getMaxStealValueRecursiveMemoStart(int[] itemValue, int[] itWeights, int bagWeight,
            int currItemIndex) {
        int[][] memo = new int[itemValue.length][bagWeight + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMaxStealValueRecursiveMemo(itemValue, itWeights, bagWeight, currItemIndex, memo);
    }

    // ***************************

    public static int getMaxStealValueTabulation(int[] itValues, int[] itWeights, int bagWeight,
            int totalItems) {
        // Create a 2D DP array to store the maximum value for each subproblem
        int dp[][] = new int[totalItems][bagWeight + 1];

        // Base Condition
        for (int i = itWeights[0]; i <= bagWeight; i++) {
            dp[0][i] = itValues[0];
        }

        for (int ind = 1; ind < totalItems; ind++) {
            for (int cap = 0; cap <= bagWeight; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = dp[ind - 1][cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (itWeights[ind] <= cap) {
                    taken = itValues[ind] + dp[ind - 1][cap - itWeights[ind]];
                }

                // Store the maximum value for the current state
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last rowwand last column of the DP array
        return dp[totalItems - 1][bagWeight];
    }

    // *************************

    public static int getMaxStealValueSpaceOpti(int[] itValues, int[] itWeights, int bagWeight,
            int totalItems) {
        // Create an array to store the maximum value for each capacity (previous row)
        int prev[] = new int[bagWeight + 1];

        // Base Condition: Initialize the first row of the array
        for (int i = itWeights[0]; i <= bagWeight; i++) {
            prev[i] = itValues[0];
        }

        // Iterate through each item and capacity
        for (int ind = 1; ind < totalItems; ind++) {
            for (int cap = bagWeight; cap >= 0; cap--) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = prev[cap];

                // Calculate the maximum value when the current item is taken
                int taken = Integer.MIN_VALUE;
                if (itWeights[ind] <= cap) {
                    taken = itValues[ind] + prev[cap - itWeights[ind]];
                }

                // Update the array with the maximum value for the current capacity
                prev[cap] = Math.max(notTaken, taken);
            }
        }

        // The result is stored in the last element of the array
        return prev[bagWeight];
    }

    // **********************

    public static void main(String[] args) {
        int[] itemsValue = { 30, 40, 60 };
        int[] itemsWeight = { 3, 2, 5 };
        int bagWeight = 7;
        int itemCount = itemsWeight.length;

        // for memo entry check
        // int[] itemsValue = { 2, 3, 4, 5, 6, 7, 8, 4, 3, 2 };
        // int[] itemsWeight = { 2, 4, 5, 3, 2, 1, 3, 5, 3, 2 };
        // int bagWeight = 14;
        // int itemCount=itemsWeight.length;

        System.out.println("Max steal value(recu)       :"
                + getMaxStealValueRecursive(itemsValue, itemsWeight, bagWeight, itemCount - 1));
        System.out.println("Max steal value(memo)       :"
                + getMaxStealValueRecursiveMemoStart(itemsValue, itemsWeight, bagWeight, itemCount - 1));
        System.out.println("Max steal value(tabu)       :"
                + getMaxStealValueTabulation(itemsValue, itemsWeight, bagWeight, itemCount));
        System.out.println("Max steal value(spac)       :"
                + getMaxStealValueSpaceOpti(itemsValue, itemsWeight, bagWeight, itemCount));
    }
}
