package com.tuf.dp;

import java.sql.Time;
import java.util.Arrays;

public class TriangleReachBottom {
    // fixed start and variable point(0,0)(any cell of last row)
    // ************
    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N)
    public static int getMinpathToBottomRecursiveStart(int[][] triangle) {
        int rows = triangle.length;
        int cols = triangle[rows - 1].length;
        int i = 0;
        int j = 0;
        return getMinpathToBottomRecursive(triangle, rows, cols, i, j);
    }

    public static int getMinpathToBottomRecursive(int[][] triangle,
            int rows, int cols, int i, int j) {
        if (i == rows - 1) {// if reached last row
            return triangle[i][j];
        }
        int down = triangle[i][j] + getMinpathToBottomRecursive(triangle, rows, cols, i + 1, j);
        int diagnal = triangle[i][j] + getMinpathToBottomRecursive(triangle, rows, cols, i + 1, j + 1);
        return Math.min(down, diagnal);
    }

    // ********************************

    public static int getMinpathToBottomRecursiveMemoStart(int[][] triangle) {
        int rows = triangle.length;
        int cols = triangle[rows - 1].length;
        int i = 0;
        int j = 0;
        int[][] memo = new int[rows][cols];
        for (int k = 0; k < memo.length; k++) {
            Arrays.fill(memo[k], -1);
        }
        return getMinpathToBottomRecursiveMemo(triangle, rows, cols, i, j, memo);
    }

    public static int getMinpathToBottomRecursiveMemo(int[][] triangle,
            int rows, int cols, int i, int j, int[][] memo) {
        if (i == rows - 1)// if reached last row
            return triangle[i][j];
        if (memo[i][j] != -1)
            return memo[i][j];
        int down = triangle[i][j] + getMinpathToBottomRecursiveMemo(triangle, rows, cols, i + 1, j, memo);
        int diagnal = triangle[i][j] + getMinpathToBottomRecursiveMemo(triangle, rows, cols, i + 1, j + 1, memo);
        memo[i][j] = Math.min(down, diagnal);
        return memo[i][j];
    }

    // ********************************

    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N)
    public static int getMinpathToBottomTabulationStart(int[][] triangle) {
        int rows = triangle.length;
        return getMinpathToBottomTabulation(triangle, rows);// rows=rows*rows
    }

    static int getMinpathToBottomTabulation(int[][] triangle, int n) {
        // Create a 2D array to store intermediate results
        int dp[][] = new int[n][n];

        // Initialize the bottom row of dp with the values from the bottom row of the
        // triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        // Starting from the second to last row, calculate the minimum path sum for each
        // element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];

                // Store the minimum of the two paths in dp
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // The result is stored at the top of dp array
        return dp[0][0];
    }

    // ********************************

    public static int getMinpathToBottomSpaceOptiStart(int[][] matrix) {
        return getMinpathToBottomSpaceOpti(matrix, matrix.length);
    }

    // Time Complexity: O(N*N)
    // Space Complexity: O(N)
    public static int getMinpathToBottomSpaceOpti(int[][] triangle, int n) {
        // Create two arrays to store intermediate results: front and cur
        int[] front = new int[n]; // Stores the results for the current row
        int[] cur = new int[n]; // Stores the results for the next row

        // Initialize the front array with the values from the bottom row of the
        // triangle
        for (int j = 0; j < n; j++) {
            front[j] = triangle[n - 1][j];
        }

        // Starting from the second to last row, calculate the minimum path sum for each
        // element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle[i][j] + front[j];
                int diagonal = triangle[i][j] + front[j + 1];

                // Store the minimum of the two paths in the cur array
                cur[j] = Math.min(down, diagonal);
            }

            // Update the front array with the values from the cur array for the next row
            front = cur.clone();
        }

        // The result is stored at the top of the front array
        return front[0];
    }

    public static void main(String[] args) {
        int[][] triangle = {
                { 1 },
                { 2, 3 },
                { 20, 6, 7 },
                { 6, 9, 16, 10 },
        };
        System.out.println("Min path to bottom(recursive)           :" + getMinpathToBottomRecursiveStart(triangle));
        System.out
                .println("Min path to bottom(recursive+memo)      :" + getMinpathToBottomRecursiveMemoStart(triangle));

        System.out.println("Min path to bottom(tabulation)          :" +
                getMinpathToBottomTabulationStart(triangle));

        System.out.println("Min path to bottom(space-opti)          :" +

                getMinpathToBottomSpaceOptiStart(triangle));
    }

}
