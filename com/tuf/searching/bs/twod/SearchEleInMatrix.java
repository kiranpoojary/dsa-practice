package com.tuf.searching.bs.twod;

public class SearchEleInMatrix {

    public static boolean isElementExist(int[][] arr, int target) {// TC: O(log2(n*m)) ; SC:O(1)
        int m = arr.length;
        int n = arr[0].length;
        int low = 0;
        int high = (m * n) - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;
            if (arr[row][col] == target)
                return true;
            else if (arr[row][col] < target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 4, 5 },
                { 7, 8, 9, 11 },
                { 12, 13, 14, 16 },
                { 17, 18, 19, 22 },
                { 24, 25, 27, 29 }
        };

        System.out.println("Search BS   :" + isElementExist(matrix, 13));

    }
}