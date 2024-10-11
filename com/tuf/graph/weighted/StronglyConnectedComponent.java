package com.tuf.graph.weighted;

import java.io.*;
import java.util.*;

public class StronglyConnectedComponent {
    // https://www.youtube.com/watch?v=R6uoSjZ2imo&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=179

    private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj,
            Stack<Integer> st) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    private static void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, adjT);
            }
        }
    }

    // Function to find number of strongly connected components in the graph.
    public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for (Integer it : adj.get(i)) {
                // i -> it
                // it -> i
                adjT.get(it).add(i);
            }
        }
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.peek();
            st.pop();
            if (vis[node] == 0) {
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                { 1, 0 }, { 0, 2 },
                { 2, 1 }, { 0, 3 },
                { 3, 4 }
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        System.out.println("Strongly connected components count is   : " + StronglyConnectedComponent.kosaraju(n, adj));
    }
}
