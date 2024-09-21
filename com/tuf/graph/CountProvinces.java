package com.tuf.graph;

import java.util.*;

public class CountProvinces {

    // TC:O(n)+O(V+2E) SC: O(n)+O(n)
    public static int countProvinces(int totalNodes, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] visited = new boolean[totalNodes + 1];
        int provinceCount = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                ++provinceCount;
                DfsTraversal.doGraphDFS(i, adj, dfs, visited); // visit all nodes of graph
            }
        }
        return provinceCount;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(2, 1, 3)));
        adj.add(new ArrayList<>(Arrays.asList(3, 1, 2, 4)));
        adj.add(new ArrayList<>(Arrays.asList(4, 3)));
        adj.add(new ArrayList<>(Arrays.asList(5, 6, 7)));
        adj.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        adj.add(new ArrayList<>(Arrays.asList(7, 5, 6)));
        adj.add(new ArrayList<>(Arrays.asList(8, 9)));
        adj.add(new ArrayList<>(Arrays.asList(9, 8)));
        System.out.println("Provinces Count    :" + CountProvinces.countProvinces(9, adj));
    }

}
