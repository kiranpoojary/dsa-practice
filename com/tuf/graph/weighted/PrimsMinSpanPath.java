package com.tuf.graph.weighted;

import java.util.*;

class PairPrimsPath {
    int node;
    int weight;

    PairPrimsPath(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

class PrimsMinSpanPath {
    // not in playlist
    // Function to get the edges of the minimum spanning tree using Prim's algorithm
    public static ArrayList<ArrayList<Integer>> getMinSpanTreeInfo(ArrayList<ArrayList<PairPrimsPath>> adj,
            int nodeCount) {
        boolean[] inMST = new boolean[nodeCount]; // Track included nodes
        int[] key = new int[nodeCount]; // Minimum weight edge
        int[] parent = new int[nodeCount]; // Store the MST structure

        PriorityQueue<PairPrimsPath> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));

        Arrays.fill(key, Integer.MAX_VALUE); // Initialize keys to infinity
        Arrays.fill(parent, -1); // Initialize parent array

        key[0] = 0; // Start from node 0
        pq.add(new PairPrimsPath(0, 0)); // Add (weight, node)

        ArrayList<ArrayList<Integer>> mstEdges = new ArrayList<>(); // Store MST edges

        while (!pq.isEmpty()) {
            PairPrimsPath pair = pq.poll();
            int u = pair.node; // Get the node with the smallest edge

            if (inMST[u])
                continue; // Skip if already included

            inMST[u] = true; // Mark as included

            // Add the edge (parent[u], u) to the MST, except for the root node
            if (parent[u] != -1) {
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(parent[u]); // Add parent node
                edge.add(u); // Add current node
                mstEdges.add(edge); // Store the edge
            }

            // Process all adjacent nodes
            for (PairPrimsPath neighbor : adj.get(u)) {
                int v = neighbor.node; // Neighbor node
                int weight = neighbor.weight; // Weight of the edge

                // If v is not in the MST and weight of edge u-v is smaller than the current key
                // of v
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight; // Update key
                    parent[v] = u; // Update parent
                    pq.add(new PairPrimsPath(v, weight)); // Add to priority queue
                }
            }
        }

        return mstEdges; // Return the edges of the MST
    }

    public static void main(String[] args) {
        int nodeCount = 5;
        ArrayList<ArrayList<PairPrimsPath>> adj = new ArrayList<>();

        // Initialize adjacency list for each node
        for (int i = 0; i < nodeCount; i++) {
            adj.add(new ArrayList<>()); // Add empty list for each node
        }

        // Add edges (node1, node2, weight) for each node
        adj.get(0).add(new PairPrimsPath(1, 2));
        adj.get(0).add(new PairPrimsPath(2, 1));

        adj.get(1).add(new PairPrimsPath(0, 2));
        adj.get(1).add(new PairPrimsPath(2, 1));

        adj.get(2).add(new PairPrimsPath(0, 1));
        adj.get(2).add(new PairPrimsPath(1, 1));
        adj.get(2).add(new PairPrimsPath(4, 2));
        adj.get(2).add(new PairPrimsPath(3, 2));

        adj.get(3).add(new PairPrimsPath(2, 2));
        adj.get(3).add(new PairPrimsPath(4, 1));

        adj.get(4).add(new PairPrimsPath(2, 2));
        adj.get(4).add(new PairPrimsPath(3, 1));

        ArrayList<ArrayList<Integer>> mst = PrimsMinSpanPath.getMinSpanTreeInfo(adj, nodeCount);

        // Print the edges of the Minimum Spanning Tree
        System.out.println("Minimum Spanning Tree edges:");
        for (ArrayList<Integer> edge : mst) {
            System.out.println(edge.get(0) + " - " + edge.get(1)); // Print each edge
        }
    }
}
