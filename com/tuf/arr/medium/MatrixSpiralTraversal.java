package com.tuf.arr.medium;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralTraversal {

    public List<Integer> spiralMatrixVisit(int[][] matrix) { // TC : O(mn); SC: O(mn)
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>(); // SC: O(mn)

        while (top <= bottom && left <= right) { // TC : O(mn)
            for (int i = left; i <= right; i++) {
                // System.out.print(matrix[top][i] + " ");
                ans.add(matrix[top][i]);
            }
            ++top;
            for (int i = top; i <= bottom; i++) {
                // System.out.print(matrix[i][right] + " ");
                ans.add(matrix[i][right]);

            }
            --right;
            if (top <= bottom) // IMP if 1d array
                for (int i = right; i >= left; i--) {
                    // System.out.print(matrix[bottom][i] + " ");
                    ans.add(matrix[bottom][i]);

                }
            --bottom;

            if (left <= right) // IMP if 1d array
                for (int i = bottom; i >= top; i--) {
                    // System.out.print(matrix[i][left] + " ");
                    ans.add(matrix[i][left]);
                }
            ++left;
        }

        return ans;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 6, 7, 8, 9, 10 },
                { 11, 12, 13, 14, 15 },
                { 16, 17, 18, 19, 20 }
        };
        MatrixSpiralTraversal m = new MatrixSpiralTraversal();
        System.out.println(m.spiralMatrixVisit(matrix));
    }
}
