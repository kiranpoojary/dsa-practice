package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasShortestPath {
    // Displays path nodes

    public static ArrayList<Integer> getShortestPathNodes(ArrayList<ArrayList<ArrayList<Integer>>> adj, int src,
            int destination) {
        PriorityQueue<DistancePair> minHeapQueue = new PriorityQueue<DistancePair>((a, b) -> a.distance - b.distance);

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int src = 1;
        int totalVertices = 6;
        int[][] edges = {
                {}
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i <= totalVertices; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 4)));

        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 4)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 2)));

        adj.get(3).add(new ArrayList<>(Arrays.asList(1, 4)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(5, 1)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(6, 6)));

        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 3)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(6, 2)));

        adj.get(5).add(new ArrayList<>(Arrays.asList(3, 1)));
        adj.get(5).add(new ArrayList<>(Arrays.asList(6, 3)));

        adj.get(6).add(new ArrayList<>(Arrays.asList(4, 2)));
        adj.get(6).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(6).add(new ArrayList<>(Arrays.asList(5, 3)));

        // ArrayList<Integer> path=

        // int[] ans = DijkstrasPQueue.getShortestPath(6, adj, src);
        // for (int i = 0; i < ans.length; i++) {
        // System.out.print(i + "->" + ans[i] + ", ");
        // }

    }

}
