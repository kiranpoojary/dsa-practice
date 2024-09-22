package com.tuf.graph.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    // rotten organge is 2
    // fresh organge is 1
    // rotten organge can rotten fresh neighbor orange in 1 unit of time
    // find total time unit taken by all to rotten all possible oranges

    public static int countRottenTime(int[][] orangeBox) {
        Queue<ArrayList<Integer>> q = new LinkedList<>();

        // Add all initially rotten oranges to the queue
        for (int i = 0; i < orangeBox.length; i++) {
            for (int j = 0; j < orangeBox[0].length; j++) {
                if (orangeBox[i][j] == 2) {
                    q.add(new ArrayList<>(Arrays.asList(i, j, 0)));
                }
            }
        }

        int timeUnits = 0;
        int[] neighbourRowSetter = { -1, 0, 1, 0 };
        int[] neighbourColSetter = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            ArrayList<Integer> topOrange = q.poll();
            int currRow = topOrange.get(0);
            int currCol = topOrange.get(1);
            int tm = topOrange.get(2);

            // If rotting a neighboring orange, update timeUnits
            for (int i = 0; i < 4; i++) {
                int neighborRow = currRow + neighbourRowSetter[i];
                int neighborCol = currCol + neighbourColSetter[i];
                if (neighborRow >= 0 && neighborRow < orangeBox.length && neighborCol >= 0
                        && neighborCol < orangeBox[0].length
                        && orangeBox[neighborRow][neighborCol] == 1) {

                    orangeBox[neighborRow][neighborCol] = 2; // Mark as rotten
                    timeUnits = tm + 1;
                    q.add(new ArrayList<>(Arrays.asList(neighborRow, neighborCol, timeUnits)));
                }
            }
        }

        return timeUnits;
    }

    public static void main(String[] args) {
        // Example adjacency matrix representing the graph
        int[][] orangeBox = {
                { 2, 1, 1, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 0 },
                { 1, 0, 2, 1 },
        };
        System.out.println("Original Organge Box");
        for (int i = 0; i < orangeBox.length; i++) {
            for (int j = 0; j < orangeBox[0].length; j++) {
                System.out.print(orangeBox[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Rotten Organge Box after " + RottenOranges.countRottenTime(orangeBox) + " days");
        for (int i = 0; i < orangeBox.length; i++) {
            for (int j = 0; j < orangeBox[0].length; j++) {
                System.out.print(orangeBox[i][j] + " ");
            }
            System.out.println();
        }
    }

}
