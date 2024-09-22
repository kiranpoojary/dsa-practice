package com.tuf.graph.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=edXdVwkYHF8&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=138
public class ShortestCellDistance {
    // distance to cell with 0 from cell with nearest 1
    public static int[][] findShortestDistance(int[][] matrix) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();// <i,j,dist>
        int[][] distMat = new int[matrix.length][matrix[0].length];
        boolean[][] visitedMat = new boolean[matrix.length][matrix[0].length];
        // add all 1 to visited and q with <i,j,0> 0 is distance
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    visitedMat[i][j] = true;
                    q.add(new ArrayList<>(Arrays.asList(i, j, 0)));
                }
            }
        }
        while (!q.isEmpty()) {
            ArrayList<Integer> curr = q.poll();
            int nodeRow = curr.get(0);
            int nodeCol = curr.get(1);
            int dist = curr.get(2);
            distMat[nodeRow][nodeCol] = dist; // add curr node distance to dist matrix
            int[] neighbourRowSetter = { -1, 0, 1, 0 };
            int[] neighbourColSetter = { 0, 1, 0, -1 };
            for (int i = 0; i < 4; i++) { // visit all unvisited neight of curr and make it visited and push to Q
                int neighborRow = nodeRow + neighbourRowSetter[i];
                int neighborCol = nodeCol + neighbourColSetter[i];
                if (neighborRow >= 0 && neighborRow < matrix.length && neighborCol >= 0
                        && neighborCol < matrix[0].length
                        && (!visitedMat[neighborRow][neighborCol])) {
                    visitedMat[neighborRow][neighborCol] = true;
                    q.add(new ArrayList<>(Arrays.asList(neighborRow, neighborCol, dist + 1)));
                }
            }

        }
        return distMat;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 0, 1 },
        };
        int[][] resultMat = findShortestDistance(matrix);

        for (int i = 0; i < resultMat.length; i++) {
            for (int j = 0; j < resultMat[0].length; j++) {

                System.out.print(resultMat[i][j] + " ");
            }
            System.out.println();
        }

    }

}
