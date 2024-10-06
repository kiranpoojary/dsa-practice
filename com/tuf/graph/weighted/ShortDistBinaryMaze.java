package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortDistBinaryMaze {
    // used Dijkstras algo

    public static int getShortDistance(int[][] grid, int[] source, int[] destination) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>(Arrays.asList(0, source[0], source[1])));
        distance[source[0]][source[1]] = 0;
        while (!q.isEmpty()) {
            int oldDist = q.peek().get(0);
            int row = q.peek().get(1);
            int col = q.peek().get(2);
            q.poll();
            int[] adjRows = { -1, 0, 1, 0 };
            int[] adjCols = { 0, 1, 0, -1 };

            for (int i = 0; i < 4; i++) {
                int adjR = row + adjRows[i];
                int adjC = col + adjCols[i];
                if (adjR >= 0 && adjR < m && adjC >= 0 && adjC < n && grid[adjR][adjC] == 1
                        && (1 + oldDist) < distance[adjR][adjC]) {
                    if (adjR == destination[0] && adjC == destination[1])
                        return 1 + oldDist;
                    distance[adjR][adjC] = (1 + oldDist);
                    q.add(new ArrayList<>(Arrays.asList((1 + oldDist), adjR, adjC)));
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 0 }
        };
        int[] src = { 0, 1 };
        int[] dest = { 2, 2 };
        System.out.println("Shortest dist is  :" + ShortDistBinaryMaze.getShortDistance(matrix, src, dest));
    }

}
