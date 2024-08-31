package com.tuf.searching.bs.twod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PeakEleInTwoD {

    private static int getMaxEleRowIndex(int[][] arr, int totalRows, int colIndex) {
        int maxEle = Integer.MIN_VALUE;
        int maxRowIndex = -1;
        for (int i = 0; i < totalRows; i++) {
            if (maxEle < arr[i][colIndex]) {
                maxEle = arr[i][colIndex];
                maxRowIndex = i;
            }
        }
        return maxRowIndex;
    }

    public static List<Integer> getPeakElementPosition(int[][] arr) {// TC: O(log2N * M) SC: O(1)
        int m = arr.length;
        int n = arr[0].length;
        int low = 0;
        int high = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            int rowIndex = getMaxEleRowIndex(arr, m, mid);
            int leftEle = (mid - 1) >= 0 ? arr[rowIndex][mid - 1] : Integer.MIN_VALUE;
            int rightEle = (mid + 1) < n ? arr[rowIndex][mid + 1] : Integer.MIN_VALUE;

            if (arr[rowIndex][mid] > leftEle && arr[rowIndex][mid] > rightEle)
                return new ArrayList<Integer>(Arrays.asList(rowIndex, mid));
            else if (leftEle > arr[rowIndex][mid])
                high = mid - 1;
            else
                low = mid + 1;

        }
        return new ArrayList<Integer>(Arrays.asList(-1, -1));
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 4, 2, 5, 1, 4, 5 },
                { 2, 9, 3, 2, 3, 2 },
                { 1, 7, 6, 0, 1, 3 },
                { 3, 6, 2, 3, 7, 2 }
        };

        System.out.println("Peak BS  : " + getPeakElementPosition(mat));
    }
}
