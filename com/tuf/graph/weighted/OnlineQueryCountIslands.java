package com.tuf.graph.weighted;

import java.util.ArrayList;

public class OnlineQueryCountIslands {

    private static boolean isValidCell(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public static ArrayList<Integer> getQueryAnswers(int[][] queries, int m, int n) {
        int[][] visited = new int[m][n];
        DisjointSet ds = new DisjointSet(m * n);
        int count = 0;
        int totalQueries = queries.length;
        ArrayList<Integer> queryAnswers = new ArrayList<>();
        for (int i = 0; i < totalQueries; i++) {
            int row = queries[i][0];
            int col = queries[i][1];
            if (visited[row][col] == 1) {
                queryAnswers.add(count);
                continue;
            }
            visited[row][col] = 1;
            ++count;
            int[] adjRows = { -1, 0, 1, 0 };
            int[] adjCols = { 0, 1, 0, -1 };
            for (int j = 0; j < 4; j++) {
                int adjR = row + adjRows[j];
                int adjC = col + adjCols[j];
                if (isValidCell(adjR, adjC, m, n)) {
                    if (visited[adjR][adjC] == 1) {
                        // get nodenumber in ds
                        int nodeNo = (row * n) + col;
                        int adjNodeNo = (adjR * n) + adjC;
                        if (ds.findUPar(nodeNo) != ds.findUPar(adjNodeNo)) {
                            --count;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            queryAnswers.add(count);
        }

        return queryAnswers;
    }

    public static void main(String[] args) {
        int[][] queries = {
                { 0, 0 },
                { 0, 0 },
                { 1, 1 },
                { 1, 0 },
                { 0, 1 },
                { 0, 3 },
                { 1, 3 },
                { 0, 4 },
                { 3, 2 },
                { 2, 2 },
                { 1, 2 },
                { 0, 2 }
        };
        System.out.println(
                "each answer for the island count queries is   :"
                        + OnlineQueryCountIslands.getQueryAnswers(queries, 4, 5));
    }
}
