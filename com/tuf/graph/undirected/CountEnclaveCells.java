package com.tuf.graph.undirected;

import java.util.LinkedList;
import java.util.Queue;

// https://www.youtube.com/watch?v=rxKcepXQgU4&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=140

class Pair {
    int row;
    int col;

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }

}

public class CountEnclaveCells {

    public static int countEnclavedCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        int matCopy[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matCopy[i][j] = mat[i][j];
                // add boundari 1's
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && mat[i][j] == 1) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] rowSlider = { -1, 0, 1, 0 };
        int[] colSlider = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            visited[row][col] = true;
            matCopy[row][col] = 0;
            for (int i = 0; i < 4; i++) {
                int neighborRow = row + rowSlider[i];
                int neighborCol = col + colSlider[i];
                if (neighborRow >= 0 && neighborRow < m && neighborCol >= 0 && neighborCol < n
                        && !visited[neighborRow][neighborCol] && matCopy[neighborRow][neighborCol] == 1) {
                    q.add(new Pair(neighborRow, neighborCol));
                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matCopy[i][j] == 1)
                    ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 0, 1, 1 },
                { 0, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 1 },
                { 0, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 1 },
        };

        System.out.println("Enclave cell count   :" + countEnclavedCells(matrix));
    }

}
