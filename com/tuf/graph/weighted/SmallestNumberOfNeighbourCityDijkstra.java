package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class PairSmallNeighbour {
    int node;
    int d;

    PairSmallNeighbour(int n, int dist) {
        this.node = n;
        this.d = dist;
    }
}

public class SmallestNumberOfNeighbourCityDijkstra {
    // use floyd warshall to generate shortest distance matrix
    // then:-
    public static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dist[i][j] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for (int i = 0; i < n; i++)
            dist[i][i] = 0;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE ||
                            dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        // dist is ready(floyd warshalls shortest path matrix)
        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold)
                    cnt++;
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;

    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[][] edges = { { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 }
        };
        int distanceThreshold = 4;

        int cityNo = SmallestNumberOfNeighbourCityDijkstra.findCity(n, m, edges, distanceThreshold);
        System.out.println("The answer is node: " + cityNo);
    }

}
