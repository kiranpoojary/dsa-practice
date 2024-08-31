package com.tuf.searching.bs.twod;

public class RowSortedMatrixMedian {
    // you are given a 2d matrix with odd number of rows and columns
    // each row elements are sorted in asc order from left to right
    // find median : brute explanation: sort all ele in 2d array and find media

    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    static int countSmallEqual(int[][] matrix, int m, int n, int x) {
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            cnt += upperBound(matrix[i], x, n);
        }
        return cnt;
    }

    static int median(int[][] matrix) {
        // median lie btw min and max val of matrix
        // find min and max for low and high
        // total number of ele is odd so median has total n/2 left ele
        // on each mid(ele for median check) check it has (n/2) lower value at left
        // if yes thats mid is median
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][n - 1]);
        }

        int req = (n * m) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int smallEqual = countSmallEqual(matrix, m, n, mid);
            if (smallEqual <= req)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4, 5 },
                { 8, 9, 11, 12, 13 },
                { 21, 23, 25, 27, 29 }
        };
        int ans = median(matrix);
        System.out.println("Median BS   : " + ans);
    }

}
