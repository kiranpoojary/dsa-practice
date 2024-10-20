package com.tuf.dp;

import java.sql.Time;
import java.util.Arrays;

public class MinimumPathSum {

    public static int getMinPathSumRecursiveStart(int[][] maze) {
        int rowCount = maze.length;
        int colCount = maze[0].length;
        int currI = rowCount - 1;
        int currJ = colCount - 1;
        return getMinPathSumRecursive(maze, rowCount, colCount, currI, currJ);
    }

    public static int getMinPathSumRecursive(int[][] paths, int rows, int cols, int currI, int currJ) {
        if (currI == 0 && currJ == 0)
            return paths[currI][currJ];
        if (currI < 0 || currJ < 0)
            return (int) 1e9; // return max value so that its ignored by .min()

        int up = paths[currI][currJ] + getMinPathSumRecursive(paths, rows, cols, currI - 1, currJ);
        int left = paths[currI][currJ] + getMinPathSumRecursive(paths, rows, cols, currI, currJ - 1);
        return Math.min(up, left);
    }

    // ***************************************

    public static int getMinPathSumRecursiveMemoStart(int[][] maze) {
        int rowCount = maze.length;
        int colCount = maze[0].length;
        int currI = rowCount - 1;
        int currJ = colCount - 1;
        int[][] memo = new int[rowCount][colCount];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return getMinPathSumRecursiveMemo(maze, rowCount, colCount, currI, currJ,
                memo);
    }

    public static int getMinPathSumRecursiveMemo(int[][] paths, int rows, int cols, int currI, int currJ,
            int[][] memo) {
        if (currI == 0 && currJ == 0)
            return paths[currI][currJ];
        if (currI < 0 || currJ < 0)
            return (int) 1e9; // return max value so that its ignored by .min()
        if (memo[currI][currJ] != -1) {
            return memo[currI][currJ];
        }
        int up = paths[currI][currJ] + getMinPathSumRecursiveMemo(paths, rows, cols, currI - 1, currJ, memo);
        int left = paths[currI][currJ] + getMinPathSumRecursiveMemo(paths, rows, cols, currI, currJ - 1, memo);
        memo[currI][currJ] = Math.min(up, left);
        return memo[currI][currJ];
    }

    // ***************************************

    // Time Complexity: O(N*M)
    // Space Complexity: O(N*M)
    public static int getMinPathSumTabulationStart(int[][] maze) {
        int rowCount = maze.length;
        int colCount = maze[0].length;
        return getMinPathSumTabulation(maze, rowCount, colCount);
    }

    public static int getMinPathSumTabulation(int[][] paths, int rows, int cols) {
        int[][] memo = new int[rows][cols];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0)
                    memo[i][j] = paths[i][j];
                else {
                    int top = paths[i][j];
                    if (i > 0)
                        top += memo[i - 1][j];
                    else
                        top += (int) 1e9;
                    int left = paths[i][j];
                    if (j > 0)
                        left += memo[i][j - 1];
                    else
                        left += (int) 1e9;

                    memo[i][j] = Math.min(top, left);
                }
            }
        }

        return memo[rows - 1][cols - 1];
    }

    // ***************************************
    // Time Complexity: O(N*M)
    // Space Complexity: O(N)
    public static int getMinPathSumTabulationSpaceOptiStart(int[][] maze) {
        int rowCount = maze.length;
        int colCount = maze[0].length;
        return getMinPathSumTabulationSpaceOpti(maze, rowCount, colCount);
    }

    public static int getMinPathSumTabulationSpaceOpti(int[][] paths, int rows, int cols) {
        int[] prev = new int[cols]; // Initialize an array to store the previous row values

        for (int i = 0; i < rows; i++) {
            int[] temp = new int[cols]; // Create a temporary array to store the current row values

            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0) {
                    temp[j] = paths[i][j]; // If we're at the top-left cell, the minimum sum is its value
                } else {
                    int top = (i > 0) ? paths[i][j] + prev[j] : Integer.MAX_VALUE; // Value from above if valid cell
                    int left = (j > 0) ? paths[i][j] + temp[j - 1] : Integer.MAX_VALUE; // Value from the left if valid
                                                                                        // cell

                    temp[j] = Math.min(top, left); // Take the minimum of the two possible paths
                }
            }
            prev = temp; // Update the previous row with the values of the current row

        }

        return prev[cols - 1]; // Final result in the last element of the last row
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 2, 4, 6 },
                { 3, 6, 3 },
                { 4, 5, 7 }
        };

        System.out.println("Min path(recursive)             :"
                + getMinPathSumRecursiveStart(maze));
        System.out.println("----------------------------------");
        System.out.println("Min path(recursive-memo)        :"
                + getMinPathSumRecursiveMemoStart(maze));
        System.out.println("----------------------------------");
        System.out.println("Min path(tabulation)            :"
                + getMinPathSumTabulationStart(maze));
        System.out.println("----------------------------------");
        System.out.println("Min path(tabulation-space-optim):"
                + getMinPathSumTabulationSpaceOptiStart(maze));
        System.out.println();
    }
}
