package com.tuf.graph.weighted;

public class CountOpToMakeOneGraph {
    // -1 means not suffiecient/minimum extra edges to connect graph

    public static int getOpCount(int[][] edges, int totalNodes) {
        totalNodes = totalNodes - 1; // -1 for 0 based nodes(idx) else this line not required
        DisjointSet ds = new DisjointSet(totalNodes); // -1
        int extraEdges = 0;
        for (int i = 0; i < edges.length; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            if (ds.findUPar(src) == ds.findUPar(dest)) {
                ++extraEdges;
            } else {
                ds.unionByRank(src, dest);
            }
        }

        System.out.println(ds.parent);
        int totalComponents = 0;
        for (int i = 0; i < totalNodes; i++) {
            if (ds.parent.get(i) == i) {
                ++totalComponents;
            }
        }
        int minimumRequiredEdges = totalComponents - 1;
        System.out.println(extraEdges + "   " + minimumRequiredEdges + "  " + totalComponents + "\n" + ds.parent);
        if (extraEdges >= minimumRequiredEdges)
            return minimumRequiredEdges;
        return -1;
    }

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };
        int totalNodes = 9;
        System.out.println("Total op required to connect all components is  :"
                + CountOpToMakeOneGraph.getOpCount(edges, totalNodes));
    }
}
