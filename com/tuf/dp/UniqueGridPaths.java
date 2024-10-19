package com.tuf.dp;

import java.sql.Time;
import java.util.Arrays;

public class UniqueGridPaths {
    // u have a grid(MxN matrix)
    // u have to find all posible unique path from (0,0) to (m-1, n-1)
    // allowed move is only down(⬇️) and right(➡️) direction only

    // row, col id grid size AND i,j for current cell in grid
    public static int getMaxUniquePathRecursive(int row, int col, int currRow, int currCol) {
        // base case: reachable
        if (currRow == 0 && currCol == 0)
            return 1;
        // base case: not-reachable
        if (currRow < 0 || currCol < 0)
            return 0;

        int up = getMaxUniquePathRecursive(row, col, currRow - 1, currCol);
        int left = getMaxUniquePathRecursive(row, col, currRow, currCol - 1);
        return up + left;
    }

    public static int getMaxUniquePathRecursiveStart(int row, int col, int currRow, int currCol) {
        return getMaxUniquePathRecursive(row, col, currRow, currCol);
    }

    // **************************************************************
    // Time Complexity: O(M*N)
    // Reason: At max, there will be M*N calls of recursion.
    // Space Complexity: O((N-1)+(M-1)) + O(M*N)
    // Reason: We are using a recursion stack space: O((N-1)+(M-1)), here
    // (N-1)+(M-1) is the path length and an external DP Array of size ‘M*N’.
    public static int getMaxUniquePathRecursiveWithMemo(int row, int col, int currRow, int currCol, int[][] memo) {
        // base case: reachable
        if (currRow == 0 && currCol == 0)
            return 1;
        // base case: not-reachable
        if (currRow < 0 || currCol < 0)
            return 0;

        if (memo[currRow][currCol] != -1)
            return memo[currRow][currCol];

        int up = getMaxUniquePathRecursiveWithMemo(row, col, currRow - 1, currCol, memo);
        int left = getMaxUniquePathRecursiveWithMemo(row, col, currRow, currCol - 1, memo);
        memo[currRow][currCol] = up + left;
        return up + left;
    }

    public static int getMaxUniquePathRecursiveWithMemoStart(int row, int col, int currRow, int currCol) {
        int[][] memo = new int[row][col];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMaxUniquePathRecursiveWithMemo(row, col, currRow, currCol, memo);
    }

    // **************************************************************

    public static int getMaxUniquePathTabulation(int row, int col, int currRow, int currCol) {
        int[][] memo = new int[row][col];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
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
        return memo[row - 1][col - 1];
    }

    public static int getMaxUniquePathTabulationStart(int row, int col, int currRow, int currCol) {
        return getMaxUniquePathTabulation(row, col, currRow, currCol);
    }

    public static int getMaxUniquePathTabuSpaceOptim(int m, int n) {
        // Create an array to store the results for the previous row
        int prev[] = new int[n];

        for (int i = 0; i < m; i++) {
            // Create a temporary array to store the results for the current row
            int temp[] = new int[n];

            for (int j = 0; j < n; j++) {
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

    public static void main(String[] args) {
        int gridTotalRows = 3;
        int gridTotalCols = 3;

        System.out.println("Max unique path(recursive)      :"
                + getMaxUniquePathRecursiveStart(gridTotalRows, gridTotalCols, gridTotalRows - 1, gridTotalCols - 1));
        System.out.println("----------------------------------");
        System.out.println("Max unique path(recursive-memo)     :"
                + getMaxUniquePathRecursiveWithMemoStart(gridTotalRows, gridTotalCols, gridTotalRows - 1,
                        gridTotalCols - 1));
        System.out.println("----------------------------------");
        System.out.println("Max unique path(tabulation)     :"
                + getMaxUniquePathTabulationStart(gridTotalRows, gridTotalCols, gridTotalRows - 1,
                        gridTotalCols - 1));
        System.out.println("----------------------------------");
        System.out.println("Max unique path(tabulation-space-optim)     :"
                + getMaxUniquePathTabuSpaceOptim(gridTotalRows, gridTotalCols));

    }
}
