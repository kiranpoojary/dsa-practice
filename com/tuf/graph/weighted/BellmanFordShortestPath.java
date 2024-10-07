package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordShortestPath {
    // https://www.youtube.com/watch?v=0vVofAhAYjc&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=168
    // works with directed graph and -ve weights
    // work with UDG but need to convert to DG
    // edge relaxation with N-1 iteration(N is node/vertices)
    // Why N-1:in each iteration shortest path to node is clacul except sourc(-1)
    // detect negative cycle: if you do nth relaxation(iteration) if value reduce
    // then -ve cycle exist
    // it's not possible to find a shortest path in a graph with a negative cycle

    public static ArrayList<Integer> getShortestDistance(int[][] graph, int nodeCount) {
        int[] distance = new int[nodeCount];
        Arrays.fill(distance, (int) 1e9);
        distance[0] = 0;

        for (int i = 0; i < nodeCount - 1; i++) { // n-1 iteration
            for (int j = 0; j < nodeCount; j++) {
                int u = graph[j][0];
                int v = graph[j][1];
                int w = graph[j][2];
                if (distance[u] != (int) 1e9 && (distance[u] + w) < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // if it again reduced then it has neg cycle
        boolean hasNegCycle = false;
        for (int j = 0; j < nodeCount; j++) {
            int u = graph[j][0];
            int v = graph[j][1];
            int w = graph[j][2];
            if (distance[u] != (int) 1e9 && (distance[u] + w) < distance[v]) {// distance is ref based
                hasNegCycle = true;
            }
        }
        ArrayList<Integer> distAns = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            distAns.add(distance[i]);
        }

        System.out.println("Is Graph has negative cycle  :" + hasNegCycle);
        return distAns;
    }

    public static void main(String[] args) {
        int nodeCount = 6;
        int[][] graphEdgeInfo = { // order not matter
                { 3, 2, 6 },
                { 5, 3, 1 },
                { 0, 1, 5 },
                { 1, 5, -3 },
                { 1, 2, -2 },
                { 3, 4, -2 },
                { 2, 4, 3 }

        };

        System.out
                .println("total reachable path         :"
                        + BellmanFordShortestPath.getShortestDistance(graphEdgeInfo, nodeCount));

        System.out.println("---------------------------");
        int[][] graphEdgeInfo2 = { // order not matter
                { 0, 1, -2 },
                { 1, 2, -1 },
                { 2, 0, 2 },

        };

        System.out
                .println("total reachable path         :"
                        + BellmanFordShortestPath.getShortestDistance(graphEdgeInfo2, 3));

    }

}
