package com.tuf.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumCoins {

    public static int getMinCoinRequiredRecursive(int[] coins, int target, int currIndex) {
        if (currIndex == 0) {
            if (target % coins[currIndex] == 0)
                return target / coins[currIndex];
            else
                return Integer.MAX_VALUE;
        } else {
            int notTake = 0 + getMinCoinRequiredRecursive(coins, target, currIndex - 1);
            int take = Integer.MAX_VALUE;
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

    public static void main(String[] args) {
        int[] coins = { 1, 2, 3, 4 };
        int target = 22;
        System.out.println(
                "Min Coins(Recursive)      : " + getMinCoinRequiredRecursive(coins, target, coins.length - 1));
        System.out.println(
                "Min Coins(Recursive-memo) : " + getMinCoinRequiredRecursiveMemoStart(coins, target));
    }
}
