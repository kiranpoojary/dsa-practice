package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasPQueue {
    // IMP

    public static int[] getShortestPath(int v,
            ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<DistancePair> minHeapQueue = new PriorityQueue<DistancePair>((a, b) -> a.distance - b.distance);
        minHeapQueue.add(new DistancePair(src, 0));
        while (!minHeapQueue.isEmpty()) {
            DistancePair qNode = minHeapQueue.poll();
            int node = qNode.node;
            int oldPathDist = qNode.distance;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);
                if ((oldPathDist + edgeWeight) < dist[edgeNode]) {
                    dist[edgeNode] = oldPathDist + edgeWeight;
                    minHeapQueue.add(new DistancePair(edgeNode, dist[edgeNode]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int src = 0;
        int totalVertices = 6;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < totalVertices; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 4)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 2)));

        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(5, 6)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 1)));

        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(5, 2)));

        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(5, 3)));

        adj.get(5).add(new ArrayList<>(Arrays.asList(3, 2)));
        adj.get(5).add(new ArrayList<>(Arrays.asList(2, 6)));
        adj.get(5).add(new ArrayList<>(Arrays.asList(4, 3)));

        int[] ans = DijkstrasPQueue.getShortestPath(6, adj, src);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(i + "->" + ans[i] + ",  ");
        }

    }

}
