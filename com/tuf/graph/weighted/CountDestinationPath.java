package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CountDestinationPath {
    // count all the shortest path to destinatopm
    // 0 based indexing
    // source is always 0 and destination always n-1
    // here 0-> 5 reachable in 2 ways with distance of 8
    // 0->2->4->5 AND 0->2->3->5

    public static int getReachablePathCount(int nodeCount, int[][] roads) {
        ArrayList<ArrayList<DistancePair>> adj = new ArrayList<>();

        for (int i = 0; i < nodeCount; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] adjList : roads) {
            adj.get(adjList[0]).add(new DistancePair(adjList[1], adjList[2]));
            adj.get(adjList[1]).add(new DistancePair(adjList[0], adjList[2]));
        }
        PriorityQueue<DistancePair> pQueue = new PriorityQueue<DistancePair>((a, b) -> a.distance - b.distance);
        int[] distance = new int[nodeCount];
        int[] waysCount = new int[nodeCount];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(waysCount, 0);
        distance[0] = 0;
        waysCount[0] = 1;
        pQueue.add(new DistancePair(0, 0));
        int mod = (int) (1e9 + 7);
        while (!pQueue.isEmpty()) {
            DistancePair p = pQueue.poll();
            int node = p.node;
            int oldDist = p.distance;

            for (DistancePair pair : adj.get(node)) {
                int nextNode = pair.node;
                int newDist = pair.distance;
                if ((oldDist + newDist) < distance[nextNode]) {
                    distance[nextNode] = (oldDist + newDist);
                    pQueue.add(new DistancePair(nextNode, (oldDist + newDist)));
                    waysCount[nextNode] = waysCount[node];
                } else if ((oldDist + newDist) == distance[nextNode]) {
                    waysCount[nextNode] = (waysCount[nextNode] + waysCount[node]) % mod;
                }
            }
        }

        return waysCount[nodeCount - 1] % mod;
    }

    public static void main(String[] args) {
        int nodeCount = 6;
        int[][] roads = {
                { 0, 1, 4 },
                { 0, 2, 4 },
                { 1, 2, 2 },
                { 2, 3, 2 },
                { 2, 4, 1 },
                { 2, 5, 6 },
                { 3, 5, 2 },
                { 4, 5, 3 },
        };

        System.out
                .println("total reachable path   :" + CountDestinationPath.getReachablePathCount(nodeCount, roads));
    }
}
