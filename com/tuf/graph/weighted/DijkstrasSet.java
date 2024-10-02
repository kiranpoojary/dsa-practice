package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DijkstrasSet {
    public static int[] getShortestPath(int v,
            ArrayList<ArrayList<ArrayList<Integer>>> adj, int src) {
        // Write your code here
        TreeSet<DistancePair> set = new TreeSet<>((node1, node2) -> {
            if (node1.node != node2.node && node1.distance == node2.distance) {
                return 1;
            }
            return node1.distance - node2.distance;
        });
        set.add(new DistancePair(src, 0));
        int[] dist = new int[v];

        for (int i = 0; i < v; i++) {
            dist[i] = (int) 1e9;
        }
        dist[src] = 0;

        while (!set.isEmpty()) {
            DistancePair node = set.pollFirst();

            for (ArrayList<Integer> adjNodes : adj.get(node.node)) {
                int adjNode = adjNodes.get(0);
                int adjNodeDist = adjNodes.get(1);

                if (dist[node.node] + adjNodeDist < dist[adjNode]) {
                    set.add(new DistancePair(adjNode, dist[node.node] + adjNodeDist));
                    dist[adjNode] = dist[node.node] + adjNodeDist;
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
