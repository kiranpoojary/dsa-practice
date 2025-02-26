package com.tuf.dp;

import java.util.Arrays;

public class TargetSum {
    // Same as CountPartitionsWithGivenDiff
    static int countTargetSumUtil(int ind, int target, int[] arr, int[][] dp) {

        if (ind == 0) {
            if (target == 0 && arr[0] == 0)
                return 2;
            if (target == 0 || target == arr[0])
                return 1;
            return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTaken = countTargetSumUtil(ind - 1, target, arr, dp);

        int taken = 0;
        if (arr[ind] <= target)
            taken = countTargetSumUtil(ind - 1, target - arr[ind], arr, dp);

        return dp[ind][target] = (notTaken + taken);
    }

    static int countTargetSum(int d, int[] arr) {
        int n = arr.length;
        int totSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totSum += arr[i];
        }

        // Checking for edge cases
        if (totSum - d < 0)
            return 0;
        if ((totSum - d) % 2 == 1)
            return 0;

        int s2 = (totSum - d) / 2;

        int dp[][] = new int[n][s2 + 1];

        for (int row[] : dp)
            Arrays.fill(row, -1);

        return countTargetSumUtil(n - 1, s2, arr, dp);
    }

    public static void main(String args[]) {
        // add + - to each subset to reach target
        int arr[] = { 5, 2, 6, 4 };
        int d = 5;
        System.out.println("Number of reached Total counts " + countTargetSum(d, arr));
    }

}
