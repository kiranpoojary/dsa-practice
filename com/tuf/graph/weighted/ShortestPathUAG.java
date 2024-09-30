package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * InnerShortestPathUAG
 */

/**
 * InnerShortestPathUAG
 */

public class ShortestPathUAG {
    // each path has unit 1 weight
    // we will follow BFS(queue) and dist array

    public static int[] getShortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        dist[src] = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int newDist = p.second + 1;
            for (Integer adjN : adj.get(p.first)) {
                if (newDist < dist[adjN]) {
                    dist[adjN] = newDist;
                    q.add(new Pair(adjN, newDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(1, 6)));
        adj.add(new ArrayList<>(Arrays.asList(0, 1, 4)));
        adj.add(new ArrayList<>(Arrays.asList(3, 5)));
        adj.add(new ArrayList<>(Arrays.asList(4, 6)));
        adj.add(new ArrayList<>(Arrays.asList(2, 5, 7, 8)));
        adj.add(new ArrayList<>(Arrays.asList(6, 8)));
        adj.add(new ArrayList<>(Arrays.asList(6, 7)));
        int src = 6;
        int[] ans = getShortestPath(adj, src);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(i + "  " + ans[i]);
        }

    }
}
