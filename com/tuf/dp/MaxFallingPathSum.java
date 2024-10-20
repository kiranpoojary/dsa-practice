package com.tuf.dp;

import java.util.ArrayList;
import java.util.Arrays;
//https://www.youtube.com/watch?v=N_aJ5qQbYA0&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=193
import java.util.Collections;
import java.util.List;

public class MaxFallingPathSum {
    // variable start and end point
    // start is top row any cell
    // reach end row any cell
    // reach with min/max paths
    // move:- down, left-diagnal, right-diagnal allowed

    public static int maxPathRecursiveStart(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int maxPath = (int) -1e9;
        for (int j = 0; j < cols; j++) {
            int cellMax = getMaxPathRecursive(mat, rows, cols, rows - 1, j);
            maxPath = Math.max(maxPath, cellMax);
        }
        return maxPath;
    }

    public static int getMaxPathRecursive(int[][] mat, int rows, int cols, int i, int j) {
        if (j < 0 || j >= cols)
            return (int) -1e9;
        if (i == 0)
            return mat[i][j];
        int up = mat[i][j] + getMaxPathRecursive(mat, rows, cols, i - 1, j);
        int ld = mat[i][j] + getMaxPathRecursive(mat, rows, cols, i - 1, j - 1);
        int rd = mat[i][j] + getMaxPathRecursive(mat, rows, cols, i - 1, j + 1);
        return Math.max(up, Math.max(ld, rd));
    }

    // *******************************

    public static int maxPathRecursiveMemoStart(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int maxPath = (int) -1e9;
        int[][] memo = new int[rows][cols];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int j = 0; j < cols; j++) {
            int cellMax = getMaxPathMemoRecursive(mat, rows, cols, rows - 1, j, memo);
            maxPath = Math.max(maxPath, cellMax);
        }
        return maxPath;
    }

    // Time Complexity: O(N*N)
    // Space Complexity: O(N) + O(N*M)
    public static int getMaxPathMemoRecursive(int[][] mat, int rows, int cols, int i, int j, int[][] memo) {
        if (j < 0 || j >= cols)
            return (int) -1e9;
        if (i == 0)
            return mat[i][j];

        if (memo[i][j] != -1)
            return memo[i][j];
        int up = mat[i][j] + getMaxPathMemoRecursive(mat, rows, cols, i - 1, j, memo);
        int ld = mat[i][j] + getMaxPathMemoRecursive(mat, rows, cols, i - 1, j - 1, memo);
        int rd = mat[i][j] + getMaxPathMemoRecursive(mat, rows, cols, i - 1, j + 1, memo);
        memo[i][j] = Math.max(up, Math.max(ld, rd));
        return memo[i][j];
    }

    // *******************************

    public static int maxPathTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the maximum path sum for each cell in the matrix
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + dp[i - 1][j];

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += dp[i - 1][j - 1];
                } else {
                    leftDiagonal += (int) Math.pow(-10, 9);
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += dp[i - 1][j + 1];
                } else {
                    rightDiagonal += (int) Math.pow(-10, 9);
                }

                // Store the maximum of the three paths in dp
                dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        // Find the maximum value in the last row of dp
        int maxi = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, dp[n - 1][j]);
        }

        return maxi;
    }

    // *******************************

    public static int maxPathTabulationSpaceOpti(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> prev = new ArrayList<>(Collections.nCopies(m, 0));
        List<Integer> cur = new ArrayList<>(Collections.nCopies(m, 0));

        // Initializing the first row - base condition
        for (int j = 0; j < m; j++) {
            prev.set(j, matrix[0][j]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + prev.get(j);

                int leftDiagonal = matrix[i][j];
                if (j - 1 >= 0) {
                    leftDiagonal += prev.get(j - 1);
                } else {
                    leftDiagonal += -1e9;
                }

                int rightDiagonal = matrix[i][j];
                if (j + 1 < m) {
                    rightDiagonal += prev.get(j + 1);
                } else {
                    rightDiagonal += -1e9;
                }

                // Store the maximum of the three paths in cur
                cur.set(j, Math.max(up, Math.max(leftDiagonal, rightDiagonal)));
            }

            // Update the prev list with the values from the cur list for the next row
            prev = new ArrayList<>(cur);
        }

        int maxi = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            maxi = Math.max(maxi, prev.get(j));
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 10, 4 },
                { 100, 3, 2, 1 },
                { 1, 1, 20, 2 },
                { 1, 2, 2, 1 }
        };

        System.out.println("Max falling path sum(recursive)             :" + maxPathRecursiveStart(matrix));
        System.out.println("Max falling path sum(memo)                  :" + maxPathRecursiveMemoStart(matrix));
        System.out.println("Max falling path sum(tab)                   :" + maxPathTabulation(matrix));
        System.out.println("Max falling path sum(space-opti)            :" + maxPathTabulationSpaceOpti(matrix));
    }
}
