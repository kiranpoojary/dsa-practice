package com.tuf.dp;

import java.util.Arrays;

public class ChocolatePick {

    public static int getMaxChocoRecursive(int[][] choco, int rows, int cols, int i, int j1, int j2) {
        if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols)// if outofbound
            return (int) -1e8;
        if (i == rows - 1) {// if reached last row
            if (j1 == j2)
                return choco[i][j1];
            else
                return choco[i][j1] + choco[i][j2];
        }

        int maxi = Integer.MIN_VALUE;
        for (int deltaI = -1; deltaI <= 1; deltaI++) {
            for (int deltaJ = -1; deltaJ <= 1; deltaJ++) {
                int ans = 0;
                if (j1 == j2)
                    ans = choco[i][j1] + getMaxChocoRecursive(choco, rows, cols, i + 1, j1 + deltaI, j2 + deltaJ);
                else
                    ans = choco[i][j1] + choco[i][j2]
                            + getMaxChocoRecursive(choco, rows, cols, i + 1, j1 + deltaI, j2 + deltaJ);
                maxi = Math.max(maxi, ans);
            }
        }
        return maxi;
    }

    public static int getMaxChocoRecursiveStart(int[][] choco) {
        int rows = choco.length;
        int cols = choco[0].length;

        return getMaxChocoRecursive(choco, rows, cols, 0, 0, cols - 1);
    }

    // *********************

    public static int getMaxChocoRecursiveMemo(int[][] choco, int rows, int cols, int i, int j1, int j2,
            int[][][] memo) {
        if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols)// if outofbound
            return (int) -1e8;
        if (i == rows - 1) {// if reached last row
            if (j1 == j2)
                return choco[i][j1];
            else
                return choco[i][j1] + choco[i][j2];
        }

        if (memo[i][j1][j2] != -1) {
            return memo[i][j1][j2];
        }
        int maxi = Integer.MIN_VALUE;
        for (int deltaI = -1; deltaI <= 1; deltaI++) {
            for (int deltaJ = -1; deltaJ <= 1; deltaJ++) {
                int ans = 0;
                if (j1 == j2)
                    ans = choco[i][j1]
                            + getMaxChocoRecursiveMemo(choco, rows, cols, i + 1, j1 + deltaI, j2 + deltaJ, memo);
                else
                    ans = choco[i][j1] + choco[i][j2]
                            + getMaxChocoRecursiveMemo(choco, rows, cols, i + 1, j1 + deltaI, j2 + deltaJ, memo);
                maxi = Math.max(maxi, ans);
            }
        }
        memo[i][j1][j2] = maxi;
        return memo[i][j1][j2];
    }

    public static int getMaxChocoRecursiveMemoStart(int[][] choco) {
        int rows = choco.length;
        int cols = choco[0].length;
        int[][][] memo = new int[rows][cols][cols];

        for (int row1[][] : memo) {
            for (int row2[] : row1) {
                Arrays.fill(row2, -1);
            }
        }

        return getMaxChocoRecursiveMemo(choco, rows, cols, 0, 0, cols - 1, memo);
    }

    // *********************

    public static int getMaxChocoTabulation(int[][] choco, int rows, int cols) {
        // Create a 3D array to store computed results
        int dp[][][] = new int[rows][cols][cols];

        // Initialize the dp array with values from the last row of the grid
        for (int j1 = 0; j1 < cols; j1++) {
            for (int j2 = 0; j2 < cols; j2++) {
                if (j1 == j2)
                    dp[rows - 1][j1][j2] = choco[rows - 1][j1];
                else
                    dp[rows - 1][j1][j2] = choco[rows - 1][j1] + choco[rows - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the
        // first row
        for (int i = rows - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = choco[i][j1];
                            else
                                ans = choco[i][j1] + choco[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= cols) || (j2 + dj < 0 || j2 + dj >= cols))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += dp[i + 1][j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result irowsthe dp array
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        // The final result is stored at the top row (first row) of the dp array
        return dp[0][0][cols - 1];

    }

    public static int getMaxChocoTabulationStart(int[][] choco) {
        int rows = choco.length;
        int cols = choco[0].length;
        return getMaxChocoTabulation(choco, rows, cols);
    }

    // *********************

    public static int getMaxChocoSpaceOpti(int[][] choco, int rows, int cols) {
        // Create two 2D arrays to store computed results: front and cur
        int[][] front = new int[cols][cols];
        int[][] cur = new int[cols][cols];

        // Initialize the front array with values from the last row of the grid
        for (int j1 = 0; j1 < cols; j1++) {
            for (int j2 = 0; j2 < cols; j2++) {
                if (j1 == j2)
                    front[j1][j2] = choco[rows - 1][j1];
                else
                    front[j1][j2] = choco[rows - 1][j1] + choco[rows - 1][j2];
            }
        }

        // Outer nested loops to traverse the DP array from the second last row to the
        // first row
        for (int i = rows - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {
                    int maxi = Integer.MIN_VALUE;

                    // Inner nested loops to try out 9 options
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2)
                                ans = choco[i][j1];
                            else
                                ans = choco[i][j1] + choco[i][j2];

                            // Check if the indices are valid
                            if ((j1 + di < 0 || j1 + di >= cols) || (j2 + dj < 0 || j2 + dj >= cols))
                                ans += (int) Math.pow(-10, 9);
                            else
                                ans += front[j1 + di][j2 + dj];

                            // Update maxi with the maximum result
                            maxi = Math.max(ans, maxi);
                        }
                    }
                    // Store the result in the cur array
                    cur[j1][j2] = maxi;
                }
            }

            // Update the front array with the values from the cur array for the next row
            for (int a = 0; a < cols; a++) {
                front[a] = cur[a].clone();
            }
        }

        // The final result is stored at the top left corner of the front array
        return front[0][cols - 1];

    }

    public static int getMaxChocoSpaceOptiStart(int[][] choco) {
        int rows = choco.length;
        int cols = choco[0].length;
        return getMaxChocoSpaceOpti(choco, rows, cols);
    }

    public static void main(String[] args) {
        int[][] choco = {
                { 2, 3, 1, 2 },
                { 3, 4, 2, 2 },
                { 5, 6, 3, 5 },
                { 1, 4, 2, 2 }
        };

        System.out.println("Max choco(recursive)        :" + getMaxChocoRecursiveStart(choco));
        System.out.println("Max choco(rec-memo)         :" + getMaxChocoRecursiveMemoStart(choco));
        System.out.println("Max choco(tabulation)       :" + getMaxChocoTabulationStart(choco));
        System.out.println("Max choco(space-Opti)       :" + getMaxChocoSpaceOptiStart(choco));
    };
}
