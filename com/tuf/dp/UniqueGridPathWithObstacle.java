package com.tuf.dp;

import java.util.Arrays;

public class UniqueGridPathWithObstacle {
    // This is same as UniqueGridPaths.java, but here u have obstacle(-1)
    // u have a grid(MxN matrix)
    // u have to find all posible unique path from (0,0) to (m-1, n-1)
    // allowed move is only down(⬇️) and right(➡️) direction only

    // row, col id grid size AND i,j for current cell in grid
    public static int getMaxUniquePathRecursive(int[][] grid, int row, int col, int currRow, int currCol) {

        // if valid cell but an obstacle
        if (currRow >= 0 && currCol >= 0 && grid[currRow][currCol] == -1)
            return 0;
        // base case: reachable
        if (currRow == 0 && currCol == 0)
            return 1;
        // base case: not-reachable
        if (currRow < 0 || currCol < 0)
            return 0;

        int up = getMaxUniquePathRecursive(grid, row, col, currRow - 1, currCol);
        int left = getMaxUniquePathRecursive(grid, row, col, currRow, currCol - 1);
        return up + left;
    }

    public static int getMaxUniquePathRecursiveStart(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int currRow = row - 1;
        int currCol = col - 1;
        return getMaxUniquePathRecursive(grid, row, col, currRow, currCol);
    }

    // **************************************************************
    // Time Complexity: O(M*N)
    // Reason: At max, there will be M*N calls of recursion.
    // Space Complexity: O((N-1)+(M-1)) + O(M*N)
    // Reason: We are using a recursion stack space: O((N-1)+(M-1)), here
    // (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
    public static int getMaxUniquePathRecursiveWithMemo(int[][] grid, int row, int col, int currRow, int currCol,
            int[][] memo) {
        // if valid cell but an obstacle
        if (currRow >= 0 && currCol >= 0 && grid[currRow][currCol] == -1)
            return 0;

        // base case: reachable
        if (currRow == 0 && currCol == 0)
            return 1;
        // base case: not-reachable
        if (currRow < 0 || currCol < 0)
            return 0;

        if (memo[currRow][currCol] != -1)
            return memo[currRow][currCol];

        int up = getMaxUniquePathRecursiveWithMemo(grid, row, col, currRow - 1, currCol, memo);
        int left = getMaxUniquePathRecursiveWithMemo(grid, row, col, currRow, currCol - 1, memo);
        memo[currRow][currCol] = up + left;
        return up + left;
    }

    public static int getMaxUniquePathRecursiveWithMemoStart(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int currRow = row - 1;
        int currCol = col - 1;

        int[][] memo = new int[row][col];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMaxUniquePathRecursiveWithMemo(grid, row, col, currRow, currCol, memo);
    }

    // **************************************************************

    public static int getMaxUniquePathTabulation(int[][] grid, int row, int col, int currRow, int currCol) {
        int[][] memo = new int[row][col];

        // if valid cell but an obstacle

        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i >= 0 && j >= 0 && grid[i][j] == -1) {
                    memo[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    memo[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = memo[i - 1][j];
                if (j > 0)
                    left = memo[i][j - 1];

                memo[i][j] = up + left;
            }
        }
        return memo[row - 1][col - 1];// ans in last (col, row)
    }

    public static int getMaxUniquePathTabulationStart(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int currRow = row - 1;
        int currCol = col - 1;
        return getMaxUniquePathTabulation(grid, row, col, currRow, currCol);
    }

    // **************************************************************

    public static int getMaxUniquePathTabuSpaceOptim(int[][] grid, int m, int n) {
        // Create an array to store the results for the previous row
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];

            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0 && grid[i][j] == -1) {
                    temp[j] = 0; // If there's an obstacle, no paths can go through here.
                    continue;
                }

                if (i == 0 && j == 0) {
                    // Base condition: There's one way to reach the top-left cell (0, 0)
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;

                // Calculate the number of ways by moving up (if possible) and left (if
                // possible)
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];

                // Store the total number of ways to reach the current cell in the temporary
                // array
                temp[j] = up + left;
            }

            // Set the temporary array as the previous array for the next row
            prev = temp;
        }

        // Return the number of ways to reach the bottom-right cell (m-1, n-1)
        return prev[n - 1];

    }

    public static int getMaxUniquePathTabuSpaceOptimStart(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return getMaxUniquePathTabuSpaceOptim(grid, row, col);
    }

    public static void main(String[] args) {

        int[][] grid = {
                { 0, 0, 0 },
                { 0, -1, 0 },
                { 0, 0, 0 }
        };
        int gridTotalRows = 3;
        int gridTotalCols = 3;

        System.out.println("Max unique non-obstacle path(recursive)             :"
                + getMaxUniquePathRecursiveStart(grid));
        System.out.println("----------------------------------");
        System.out.println("Max unique non-obstacle path(recursive-memo)        :"
                + getMaxUniquePathRecursiveWithMemoStart(grid));
        System.out.println("----------------------------------");
        System.out.println("Max unique non-obstacle path(tabulation)            :"
                + getMaxUniquePathTabulationStart(grid));
        System.out.println("----------------------------------");
        System.out.println("Max unique non-obstacle path(tabulation-space-optim):"
                + getMaxUniquePathTabuSpaceOptimStart(grid));
        System.out.println();
    }
}
