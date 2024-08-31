package com.tuf.searching.bs.twod;

public class SearchEleInMatrixTwo {

    public static String getTargetIndex(int[][] arr, int target) { // TC : O(m+n) ; SC: O(1)
        int m = arr.length;
        int n = arr[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (arr[row][col] == target)
                return row + ", " + col;
            else if (arr[row][col] < target)
                ++row;
            else
                --col;
        }
        return "-1, -1";
    }

    public static void main(String[] args) {
        int arr[][] = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        System.out.println("Target Index BS  : " + getTargetIndex(arr, 14));
    }
}
