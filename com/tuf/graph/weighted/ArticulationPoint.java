package com.tuf.graph.weighted;

import java.sql.Time;
import java.util.ArrayList;

public class ArticulationPoint {
    // https://www.youtube.com/watch?v=j1QDfU21iZk&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=181
    // removing a node in split the graph into more than 1 componennt
    // Time Complexity: O(V+2E), where V = no. of vertices, E = no. of edges. It is
    // because the algorithm is just a simple DFS traversal.
    // Space Complexity: O(3V), where V = no. of vertices. O(3V) is for the three
    // arrays i.e. tin, low, and vis, each of size V.

    private static int timer = 1;

    private static void dfs(int node, int parent, int[] vis,
            int tin[], int low[], int[] mark,
            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for (Integer it : adj.get(node)) {
            if (it == parent)
                continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                // node --- it
                if (low[it] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if (child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }

    // Function to return Breadth First Traversal of given graph.
    public static ArrayList<Integer> articulationPoints(int n,
            ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                ans.add(i);
            }
        }
        if (ans.size() == 0) {
            ans.add(-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 0, 3 },
                { 2, 3 },
                { 2, 4 },
                { 2, 5 },
                { 4, 6 },
                { 5, 6 },
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArrayList<Integer> nodes = ArticulationPoint.articulationPoints(n, adj);

        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            int node = nodes.get(i);
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
