package com.tuf.graph.weighted;

import java.util.*;

class PairPrims {
    int node, distance;

    PairPrims(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

}

public class PrimsMinSpanningTree {
    // https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=170
    // TC: O(E)+O(log pq.size)+ O(E log E )

    public static int getMinSpanTreeInfo(ArrayList<ArrayList<ArrayList<Integer>>> edges, int nodeCount) {
        int sum = 0;
        int[] visited = new int[nodeCount];
        PriorityQueue<PairPrims> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance); // log pq.size
        pq.add(new PairPrims(0, 0));
        // dot't set visited of 0 here(only after poll)
        while (!pq.isEmpty()) { // O(E)
            PairPrims p = pq.poll();
            int node = p.node;
            int distance = p.distance;
            if (visited[node] == 1)
                continue;
            visited[node] = 1;
            // pq always gives shortest path first
            // so id not visited and now its visiting means shortest
            sum += distance;
            for (ArrayList<Integer> ed : edges.get(node)) { // E log E
                // if node !visited add to pq
                int adjNode = ed.get(0);
                int adjWeight = ed.get(1);
                if (visited[adjNode] == 0)
                    pq.add(new PairPrims(adjNode, adjWeight));
            }

        }

        return sum;

    }

    public static void main(String[] args) {

        int nodeCount = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 1)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));

        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 2)));

        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 1)));

        System.out.println("Prims shortest spanning tree distance is    :"
                + PrimsMinSpanningTree.getMinSpanTreeInfo(adj, nodeCount));

    }
}
