package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinEffortPath {
    // used Dijkstras algo
    // src: 0,0
    // desti: n-1,m-1
    // https://www.youtube.com/watch?v=0ytpZyiZFhA&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=162

    public static int getMinEffortDistance(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<ArrayList<Integer>> q = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        distance[0][0] = 0;
        q.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        while (!q.isEmpty()) {
            int oldEffort = q.peek().get(0);
            int row = q.peek().get(1);
            int col = q.peek().get(2);
            q.poll();
            int[] adjRows = { -1, 0, 1, 0 };
            int[] adjCols = { 0, 1, 0, -1 };
            if (row == m - 1 && col == n - 1)
                return oldEffort;
            for (int i = 0; i < 4; i++) {
                int adjR = row + adjRows[i];
                int adjC = col + adjCols[i];

                if (adjR >= 0 && adjR < m && adjC >= 0 && adjC < n) {
                    // absolute value of a number is the non-negative version of that number,
                    // regardless of whether it's positive or negative.
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[adjR][adjC]), oldEffort);
                    if (newEffort < distance[adjR][adjC]) {
                        distance[adjR][adjC] = newEffort;
                        q.add(new ArrayList<>(Arrays.asList(newEffort, adjR, adjC)));
                    }

                }
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 },

        };

        System.out.println("MinEffortPath is    :" + MinEffortPath.getMinEffortDistance(heights));
    }
}
