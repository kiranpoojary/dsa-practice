package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // sorting on weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};

public class KruskalsMinSpanTree {

    public static int getKruskalsMinSpanningWeight(int nodeCount, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        DisjointSet ds = new DisjointSet(nodeCount);
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {// TC: O(N + E)
            for (int j = 0; j < adj.get(i).size(); j++) {
                int src = i;
                int dest = adj.get(i).get(j).get(0);
                int weight = adj.get(i).get(j).get(1);
                edges.add(new Edge(src, dest, weight));
            }
        }

        Collections.sort(edges); // TC: M log M

        int MSTWeight = 0;
        for (int i = 0; i < edges.size(); i++) { // TC: M x 4 x alpha x 2
            int wt = edges.get(i).weight;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if (ds.findUPar(u) != ds.findUPar(v)) {
                MSTWeight += wt;
                ds.unionBySize(u, v);
            }
        }

        return MSTWeight;
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());// initialize empty arrList
        }
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 1)));

        adj.get(1).add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));

        adj.get(2).add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(1, 1)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 2)));

        adj.get(3).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 1)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 2)));

        System.out
                .println("Kruskal min spanning weight    :" + KruskalsMinSpanTree.getKruskalsMinSpanningWeight(v, adj));

    }
}
