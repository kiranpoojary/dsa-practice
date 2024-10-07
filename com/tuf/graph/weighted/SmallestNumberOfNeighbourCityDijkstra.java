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
    public static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        List<List<PairSmallNeighbour>> adjList = new ArrayList<>(); // sc -> V^2
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        for (int[] edge : edges) {
            // bidirectional
            adjList.get(edge[0]).add(new PairSmallNeighbour(edge[1], edge[2]));
            adjList.get(edge[1]).add(new PairSmallNeighbour(edge[0], edge[2]));
        }

        PriorityQueue<PairSmallNeighbour> pq = new PriorityQueue<>((a, b) -> a.d - b.d); // sc -> V
        int city = 0;
        int cities = Integer.MAX_VALUE;
        // tc = V * (E*logV + V) => V^2 + EVlogV
        for (int i = 0; i < n; i++) {
            // find shortest dist from every node
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new PairSmallNeighbour(i, 0));
            dist[i] = 0;

            // tc - E * logV
            while (!pq.isEmpty()) {
                PairSmallNeighbour curP = pq.poll();
                int cur = curP.node, d = curP.d;
                for (PairSmallNeighbour adjP : adjList.get(cur)) {
                    int newD = d + adjP.d;
                    if (newD <= distanceThreshold && newD < dist[adjP.node]) {
                        pq.add(new PairSmallNeighbour(adjP.node, newD));
                        dist[adjP.node] = newD;
                    }
                }
            }

            // calculating city with minCities reachable in threshold
            // count cities reachable
            int citiesReachable = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[j] != Integer.MAX_VALUE) {
                    citiesReachable++;
                }
            }
            if (citiesReachable <= cities) {
                city = i;
                cities = citiesReachable;
            }
        }

        return city;
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
