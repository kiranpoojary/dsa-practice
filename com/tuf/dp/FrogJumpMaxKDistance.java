package com.tuf.dp;

import java.util.Arrays;

public class FrogJumpMaxKDistance {

    public static int getMinJumpEnergyMaxKRecursive(int index, int[] jumpHeights, int k) {

        if (index == 0)
            return 0;
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int newMin = getMinJumpEnergyMaxKRecursive(index - i, jumpHeights, k)
                        + Math.abs(jumpHeights[index] - jumpHeights[index - i]);
                minEnergy = Math.min(minEnergy, newMin);
            }
        }

        return minEnergy;
    }

    public static int getMinJumpEnergyMaxKMemoization(int index, int[] jumpHeights, int[] memo, int k) {
        if (index == 0)
            return 0;
        if (memo[index] != -1)
            return memo[index];
        int minEnergy = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (index - i >= 0) {
                int newMin = getMinJumpEnergyMaxKMemoization(index - i, jumpHeights, memo, k)
                        + Math.abs(jumpHeights[index] - jumpHeights[index - i]);
                minEnergy = Math.min(minEnergy, newMin);
            }
        }

        memo[index] = minEnergy;
        return minEnergy;
    }

    public static int getMinJumpEnergyMaxKTabulation(int index, int[] jumpHeights, int k) {
        int prev = 0;
        int curri = -1;
        int minn = Integer.MAX_VALUE;
        for (int i = 1; i < jumpHeights.length; i++) {
            curri = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int right = prev + Math.abs(jumpHeights[i] - jumpHeights[i - j]);
                    curri = Math.min(curri, right);
                }
                prev = curri;
            }
            prev = Math.min(minn, prev);
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] jumpHeights = { 30, 10, 60, 10, 60, 50 };
        int[] memo = new int[jumpHeights.length + 1];
        Arrays.fill(memo, -1);
        System.out
                .println("Min energy to jump all recursive :"
                        + getMinJumpEnergyMaxKRecursive(jumpHeights.length - 1, jumpHeights, 4));

        // System.out
        // .println("Min energy to jump all dp-memoization :"
        // + getMinJumpEnergyMaxKMemoization(jumpHeights.length - 1, jumpHeights,
        // memo, 4));
        System.out
                .println("Min energy to jump all dp-tabulation :"
                        + getMinJumpEnergyMaxKTabulation(jumpHeights.length - 1, jumpHeights, 4));

    }

}
