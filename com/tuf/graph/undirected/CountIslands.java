package com.tuf.graph.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountIslands {

    public static void bfs(int[][] adjMatrix, boolean[][] visited, int startNodeI, int startNodeJ) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        int maxRow = adjMatrix.length;
        int maxCol = adjMatrix[0].length;
        q.add(new ArrayList<>(Arrays.asList(startNodeI, startNodeJ)));
        while (!q.isEmpty()) {
            ArrayList<Integer> currNode = q.poll();
            int row = currNode.get(0);
            int col = currNode.get(1);
            visited[row][col] = true;
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (i == row && j == col)
                        continue;
                    if (i >= 0 && i <= maxRow - 1 && j >= 0 && j <= maxCol - 1 && !visited[i][j]
                            && adjMatrix[i][j] != 0) {
                        q.add(new ArrayList<>(Arrays.asList(i, j)));
                    }
                }
            }
        }

    }

    public static int countIslands(int[][] adjMatrix) {
        int count = 0;
        int m = adjMatrix.length;
        int n = adjMatrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && adjMatrix[i][j] != 0) {
                    ++count;
                    bfs(adjMatrix, visited, i, j);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example adjacency matrix representing the graph
        int[][] adjMatrix = {
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
                { 1, 1, 0, 1 },

        };
        System.out.println("Total Islands  :" + CountIslands.countIslands(adjMatrix));
    }
}
