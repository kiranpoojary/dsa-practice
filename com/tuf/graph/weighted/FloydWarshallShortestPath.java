package com.tuf.graph.weighted;

public class FloydWarshallShortestPath {
    // https://www.youtube.com/watch?v=YbY8cVwWAvw&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=167
    // it's not possible to find a shortest path in a graph with a negative cycle
    // how to detect -ve cycle: if mat[i][i]<0 then -ve cycle exist

    public static int[][] getFloydWarshallPath(int[][] adj) {
        int n = adj.length;
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if (adj[i][j] == -1) {
                    adj[i][j] = (int) 1e9;
                }
            }
        }

        for (int via = 0; via < adj.length; via++) {
            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj.length; j++) {
                    adj[i][j] = Math.min(adj[i][j], (adj[i][via] + adj[via][j]));
                }
            }
        }

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if (adj[i][j] == (int) 1e9) {
                    adj[i][j] = -1;
                }
            }
        }
        return adj;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 2, -1, -1 },
                { 1, 0, 3, -1 },
                { -1, -1, 0, -1 },
                { 3, 5, 4, 0 }
        };

        int[][] ans = getFloydWarshallPath(graph);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                System.out.print(ans[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("-------adj[i][i]<0 mean -Ve cycle ---------");
        int[][] graphEdgeInfo2 = { // order not matter
                { 0, 1, -2 },
                { 1, 2, -1 },
                { 2, 0, 2 },

        };
        int[][] ans2 = getFloydWarshallPath(graphEdgeInfo2);
        for (int i = 0; i < ans2.length; i++) {
            for (int j = 0; j < ans2.length; j++) {
                System.out.print(ans2[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
