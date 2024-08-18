package com.tuf.arr.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZero {
    public void setToZeroBrute(int[][] arr) {
        // TC: (n*m)*(n+m)+(n*m) = around O(n^3)
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++) { // TC: O(n*m)
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    this.markRow(arr, i); // TC: O(n)
                    this.markCol(arr, j); // TC: O(m)
                }
            }
        }
        for (int i = 0; i < rows; i++) { // TC: O(n*m)
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == -1)
                    arr[i][j] = 0;
            }
        }
    }

    public void setToZeroBetter(int[][] arr) { // TC: O(m*n)+ O(m*n)= O(2*m*n) ;;;; SC: O(m+n)
        int rows = arr.length;
        int cols = arr[0].length;
        int[] rowTrack = new int[rows]; // SC: O(n)
        int[] colTrack = new int[cols]; // SC: O(m)

        for (int i = 0; i < rows; i++) { // TC: O(m*n)
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    rowTrack[i] = 1;
                    colTrack[j] = 1;
                }
            }
        }
        for (int i = 0; i < rowTrack.length; i++) { // TC: O(m*n)
            for (int j = 0; j < colTrack.length; j++) {
                if (rowTrack[i] == 1 || colTrack[j] == 1) {
                    arr[i][j] = 0;
                }
            }

        }

    }

    public void setToZeroOptimal(int[][] arr) { // TC: O(2mn); SC: O(1)
        int rows = arr.length;
        int cols = arr[0].length;
        int col = 1; // SC: O(1)
        for (int i = 0; i < rows; i++) { // TC: O(m*n)
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    arr[0][j] = 0;
                    if (i != 0)
                        arr[i][0] = 0;
                    else
                        col = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) { // TC: O(m*n)--->Approx= O(m*n)-O(m)-O(n) :deducted O(m) and O(n) added again
                                         // below, so this
                                         // loop and below two loop collectively O(m*n)
            for (int j = 1; j < cols; j++) {
                if (arr[0][j] == 0 || arr[i][0] == 0) {
                    arr[i][j] = 0;
                }
            }
        }

        if (col == 0) {
            for (int j = 0; j < cols; j++) {// TC: O(m)
                arr[0][j] = 0;
            }
        }

        if (arr[0][0] == 0) {
            for (int i = 0; i < rows; i++) { // TC: O(n)
                arr[i][0] = 0;
            }
        }

    }

    private void markCol(int[][] arr, int colIndex) {
        int rows = arr.length;
        for (int i = 0; i < rows; i++) {
            arr[i][colIndex] = -1;
        }
    }

    private void markRow(int[][] arr, int rowIndex) {
        int cols = arr[0].length;
        for (int i = 0; i < cols; i++) {
            arr[rowIndex][i] = -1;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 }
        };
        int rows = arr.length;
        int cols = arr[0].length;

        SetMatrixZero s = new SetMatrixZero();
        // s.setToZeroBrute(arr);
        // s.setToZeroBetter(arr);
        // for (int i = 0; i < rows; i++) {
        // for (int j = 0; j < cols; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }

        int[][] arr2 = {
                { 1, 1, 1, 1 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 1 }
        };
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        s.setToZeroOptimal(arr2);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
