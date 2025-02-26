package com.tuf.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumCoins {

    public static int getMinCoinRequiredRecursive(int[] coins, int target, int currIndex) {
        if (currIndex == 0) {
            if (target % coins[currIndex] == 0)
                return target / coins[currIndex];
            else
                return (int) 1e9; // use 1e9 when code has 1+ to avoid int overflow
        } else {
            int notTake = 0 + getMinCoinRequiredRecursive(coins, target, currIndex - 1);
            int take = Integer.MAX_VALUE; // MAX when min required
            if (coins[currIndex] <= target) {
                take = 1 + getMinCoinRequiredRecursive(coins, target - coins[currIndex], currIndex);
            }
            return Math.min(take, notTake);
        }
    }

    // *******************************************
    public static int getMinCoinRequiredRecursiveMemo(int[] coins, int target, int currIndex, int[][] memo) {
        if (currIndex == 0) {
            if (target % coins[currIndex] == 0)
                return target / coins[currIndex];
            else
                return (int) Math.pow(10, 9);
        } else {
            if (memo[currIndex][target] != -1) {
                return memo[currIndex][target];
            } else {
                int notTake = 0 + getMinCoinRequiredRecursiveMemo(coins, target, currIndex - 1, memo);
                int take = Integer.MAX_VALUE;
                if (coins[currIndex] <= target) {
                    take = 1 + getMinCoinRequiredRecursiveMemo(coins, target - coins[currIndex], currIndex, memo);
                }
                memo[currIndex][target] = Math.min(take, notTake);
                return memo[currIndex][target];
            }

        }
    }

    public static int getMinCoinRequiredRecursiveMemoStart(int[] coins, int target) {
        int[][] memo = new int[coins.length][target + 1];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMinCoinRequiredRecursiveMemo(coins, target, coins.length - 1, memo);
    }

    // *******************************************
    static int getMinCoinRequiredTabulation(int[] coins, int T) {
        int n = coins.length;

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n][T + 1];

        // Initialize the dp array for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = (int) Math.pow(10, 9);
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = 0 + dp[ind - 1][target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (coins[ind] <= target)
                    take = 1 + dp[ind][target - coins[ind]];

                // Store the minimum result in the dp array
                dp[ind][target] = Math.min(notTake, take);
            }
        }

        // Get the minimum number of elements needed for the target sum
        int ans = dp[n - 1][T];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    // *******************************************

    static int getMinCoinRequiredTabSpaceOpti(int[] coins, int T) {
        int n = coins.length;

        // Create two arrays to store results of subproblems: prev and cur
        int prev[] = new int[T + 1];
        int cur[] = new int[T + 1];

        // Initialize the prev array for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % coins[0] == 0)
                prev[i] = i / coins[0];
            else
                prev[i] = (int) Math.pow(10, 9);
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = 0 + prev[target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (coins[ind] <= target)
                    take = 1 + cur[target - coins[ind]];

                // Store the minimum result in the cur array
                cur[target] = Math.min(notTake, take);
            }

            // Update prev with cur for the next iteration
            prev = cur.clone();
        }

        // Get the minimum number of elements needed for the target sum
        int ans = prev[T];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }

    // *******************************************

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3, 4 };
        int target = 22;
        System.out.println(
                "Min Coins(Recursive)      : " + getMinCoinRequiredRecursive(coins, target, coins.length - 1));
        System.out.println(
                "Min Coins(Recursive-memo) : " + getMinCoinRequiredRecursiveMemoStart(coins, target));
        System.out.println("Min Coins(Tab)            : " + getMinCoinRequiredTabulation(coins, target));
        System.out.println("Min Coins(Tab-spaceOpti)  : " + getMinCoinRequiredTabulation(coins, target));

    }
}
