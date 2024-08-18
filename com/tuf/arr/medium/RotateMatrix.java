package com.tuf.arr.medium;
// https://www.youtube.com/watch?v=Z0R2u6gd3GU&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=31

public class RotateMatrix {

    public int[][] rotateMatrixBy90Brute(int[][] matrix) { // TC: O(n^2) SC: O(n^2)
        int[][] ansMatrix = new int[matrix.length][matrix[0].length];
        int m = ansMatrix.length;
        int n = ansMatrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ansMatrix[j][n - i - 1] = matrix[i][j]; // IMP Line
            }
        }
        return ansMatrix;
    }

    public void rotateMatrixBy90Optimal(int[][] matrix) { // TC: O(2((m*n)/2))
        // Step By Step
        int m = matrix.length;
        int n = matrix[0].length;
        // 1. convert matrix to transpose matrix(row become column vice versa)
        for (int i = 0; i < m - 1; i++) { // TC: O((m*n)/2)
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;

            }
        }

        // 2.reverse each row to rorate matrix by 90 degree
        for (int i = 0; i < m; i++) { // TC: O((m*n)/2)
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = t;

            }
        }
        // method 2 to reverse
        // int currentRow = 0;
        // int left = 0;
        // int right = n - 1;
        // while (currentRow < m && left < right) {
        // int t = matrix[currentRow][left];
        // matrix[currentRow][left] = matrix[currentRow][right];
        // matrix[currentRow][right] = t;
        // ++left;
        // --right;
        // if (left >= right) {
        // left = 0;
        // right = n - 1;
        // ++currentRow;
        // }
        // }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        RotateMatrix r = new RotateMatrix();
        // int[][] ansMatrix = new int[matrix.length][matrix[0].length];
        // ansMatrix = r.rotateMatrixBy90Brute(matrix);
        // for (int i = 0; i < ansMatrix.length; i++) {
        // for (int j = 0; j < ansMatrix[0].length; j++) {
        // System.out.print(ansMatrix[i][j] + " ");
        // }
        // System.out.println();
        // }
        r.rotateMatrixBy90Optimal(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "    ");
            }
            System.out.println();
        }

    }
}
