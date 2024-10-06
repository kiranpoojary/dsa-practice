package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int pathCost;

    public Pair(int node, int pathCost) {
        this.node = node;
        this.pathCost = pathCost;
    }
}

class QTupple {
    int stop;
    int node;
    int cost;

    public QTupple(int stop, int node, int cost) {
        this.stop = stop;
        this.node = node;
        this.cost = cost;
    }

}

public class CheapFlightKStops {
    // https://www.youtube.com/watch?v=9XybHVqTHcQ&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=163
    // 0 based indexing
    public static int getCheapPrice(int totalNode, int[][] adj, int src, int dst, int stopCounts) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < totalNode; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < adj.length; i++) {
            adjList.get(adj[i][0]).add(new Pair(adj[i][1], adj[i][2]));
        }
        int[] distance = new int[totalNode];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<QTupple> q = new LinkedList<>();
        q.add(new QTupple(0, 0, 0));
        while (!q.isEmpty()) {
            QTupple qt = q.poll();
            int stop = qt.stop;
            int node = qt.node;
            int cost = qt.cost;

            if (stop > stopCounts)
                continue;
            for (Pair p : adjList.get(node)) {
                int adjNode = p.node;
                int adjPathCost = p.pathCost;

                if ((cost + adjPathCost) < distance[adjNode] && stop <= stopCounts) {
                    distance[adjNode] = (cost + adjPathCost);
                    q.add(new QTupple(stop + 1, adjNode, (cost + adjPathCost)));
                }
            }
        }

        if (distance[dst] == Integer.MAX_VALUE)
            return -1;
        return distance[dst];

    }

    public static void main(String[] args) {
        int[][] flightInfo = {
                { 0, 1, 5 },
                { 0, 3, 2 },
                { 1, 2, 5 },
                { 1, 4, 1 },
                { 3, 1, 2 },
                { 4, 2, 1 }
        };

        System.out
                .println("Cheapest flight with K stops is    :"
                        + CheapFlightKStops.getCheapPrice(5, flightInfo, 0, 2, 2));
    }
}
