package com.tuf.dp;

import java.util.Arrays;

public class FrogJump {
    // memoization: top-down
    // tabulation : bottom-up

    public static int getMinJumpEnergyRecursive(int ind, int[] jumpHeights) {
        if (ind == 0)
            return 0;
        int left = getMinJumpEnergyRecursive(ind - 1, jumpHeights) + Math.abs(jumpHeights[ind] - jumpHeights[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1) {
            right = getMinJumpEnergyRecursive(ind - 2, jumpHeights) + Math.abs(jumpHeights[ind] - jumpHeights[ind - 2]);
        }
        return Math.min(left, right);
    }

    public static int getMinJumpEnergyDpMemo(int ind, int[] jumpHeights, int[] memo) {
        if (memo[ind] != -1)
            return memo[ind];
        if (ind == 0)
            return 0;
        int left = getMinJumpEnergyRecursive(ind - 1, jumpHeights) + Math.abs(jumpHeights[ind] - jumpHeights[ind - 1]);
        int right = Integer.MAX_VALUE;
        if (ind > 1) { // u can't jump 2 step if u are at step1(u can jump to 0 not -1) (top-bottom)
            right = getMinJumpEnergyRecursive(ind - 2, jumpHeights) + Math.abs(jumpHeights[ind] - jumpHeights[ind - 2]);
        }
        memo[ind] = Math.min(left, right);
        return memo[ind];
    }

    public static int getMinJumpEnergyTabulation(int ind, int[] jumpHeights) {
        int prev = 0;
        int prev2 = 0;
        int curri = -1;
        for (int i = 1; i < jumpHeights.length; i++) {
            int left = prev + Math.abs(jumpHeights[i] - jumpHeights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prev2 + Math.abs(jumpHeights[i] - jumpHeights[i - 2]);
            }

            curri = Math.min(left, right);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] jumpHeights = { 30, 10, 60, 10, 60, 50 };
        int[] memo = new int[jumpHeights.length + 1];
        Arrays.fill(memo, -1);

        System.out
                .println("Min energy to jump all  recursive      :"
                        + getMinJumpEnergyRecursive(jumpHeights.length - 1, jumpHeights));

        System.out
                .println("Min energy to jump all  dp-memoization :"
                        + getMinJumpEnergyDpMemo(jumpHeights.length - 1, jumpHeights, memo));
        System.out
                .println("Min energy to jump all  dp-tabulation  :"
                        + getMinJumpEnergyTabulation(jumpHeights.length - 1, jumpHeights));

    }
}
