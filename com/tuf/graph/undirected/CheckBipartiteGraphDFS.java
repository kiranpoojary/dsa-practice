package com.tuf.graph.undirected;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckBipartiteGraphDFS {
    // bipatite means : each adj node should painted diff color
    // color each node of graph with 2 color options
    // adjecent should not have same color
    // intuition: if liner graph it is bipartite
    // intuition: if graph has cycle and cycle has even node its bipartite else not

    public static boolean paintNodeUsingDFS(ArrayList<ArrayList<Integer>> adj, int[] painted, int startNode,
            int color) {
        painted[startNode] = color;
        ArrayList<Integer> adjChilds = adj.get(startNode);
        for (Integer node : adjChilds) {
            if (node == startNode)
                continue;
            if (painted[node] == -1) {
                if (paintNodeUsingDFS(adj, painted, node, 1 - color) == false) // 1-color is 1?0:1;
                    return false;
            } else if (painted[node] == color)
                return false;
        }

        return true;
    }

    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int[] painted = new int[adj.size()];
        Arrays.fill(painted, -1);
        for (int index = 1; index < adj.size(); index++) {
            if (painted[index] == -1) {
                if (paintNodeUsingDFS(adj, painted, index, 0) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList())); // 0 index
        adjList.add(new ArrayList<>(Arrays.asList(1, 2)));
        adjList.add(new ArrayList<>(Arrays.asList(2, 1, 3, 6)));
        adjList.add(new ArrayList<>(Arrays.asList(3, 2, 4)));
        adjList.add(new ArrayList<>(Arrays.asList(4, 3, 5, 7)));
        adjList.add(new ArrayList<>(Arrays.asList(5, 4, 6)));
        adjList.add(new ArrayList<>(Arrays.asList(6, 2, 5)));
        adjList.add(new ArrayList<>(Arrays.asList(7, 4, 8)));
        adjList.add(new ArrayList<>(Arrays.asList(8, 7)));
        System.out.println("Is bipartite graph-1     :" + isBipartite(adjList));
        // -------------------
        ArrayList<ArrayList<Integer>> adjList2 = new ArrayList<>();
        adjList2.add(new ArrayList<>(Arrays.asList())); // 0 index
        adjList2.add(new ArrayList<>(Arrays.asList(1, 2)));
        adjList2.add(new ArrayList<>(Arrays.asList(2, 1, 3, 5)));
        adjList2.add(new ArrayList<>(Arrays.asList(3, 2, 4)));
        adjList2.add(new ArrayList<>(Arrays.asList(4, 3, 5, 6)));
        adjList2.add(new ArrayList<>(Arrays.asList(5, 2, 4)));
        adjList2.add(new ArrayList<>(Arrays.asList(6, 4)));
        System.out.println("Is bipartite graph-2     :" + isBipartite(adjList2));
    }

}
