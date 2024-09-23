package com.tuf.graph.undirected;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CountIdenticalIslands {

    public static ArrayList<Integer> countDFS(int[][] mat, boolean[][] visited, int row, int col,
            ArrayList nodes, int baseRow, int baseCol) {

        int m = mat.length;
        int n = mat[0].length;
        if (!visited[row][col] && mat[row][col] == 1) {
            visited[row][col] = true;
            int ii = baseRow - row;
            int jj = baseCol - col;
            // System.out.println(baseRow + "-" + baseCol);
            nodes.add(ii);
            nodes.add(jj);
            int[] rowSlider = { 0, 1, 0, -1 };
            int[] colSlider = { 1, 0, -1, 0 };
            for (int i = 0; i < 4; i++) {
                int neighborRow = row + rowSlider[i];
                int neighborCol = col + colSlider[i];
                if (neighborRow >= 0 && neighborRow < m && neighborCol >= 0 && neighborCol < n
                        && !visited[neighborRow][neighborCol] && !visited[neighborRow][neighborCol]
                        && mat[neighborRow][neighborCol] == 1) {
                    countDFS(mat, visited, neighborRow, neighborCol, nodes, baseRow, baseCol);
                }
            }
        }
        return nodes;
    }

    public static int countIdenticalIslands(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<ArrayList<Integer>> uniques = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> arr = new ArrayList<>();
                ArrayList<Integer> visitedNode = countDFS(matrix, visited, i, j, arr, i, j);
                if (visitedNode.size() > 0)
                    uniques.add(visitedNode);
            }
        }

        System.out.println(uniques);
        return uniques.size();
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 0, 1, 0 },
        };

        System.out.println("Identical island count   :" + countIdenticalIslands(matrix));
    }
}
