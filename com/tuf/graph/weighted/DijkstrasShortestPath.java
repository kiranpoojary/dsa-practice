package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

public class DijkstrasShortestPath {
    // Displays path nodes
    // One based indexing
    // source is always 1 and destination can N

    public static ArrayList<Integer> getShortestPathNodes(int nodeCount, int edgeCount, int[][] adjWeights,
            int destination) {
        int source = 1;
        ArrayList<ArrayList<DistancePair>> adj = new ArrayList<>();
        for (int i = 0; i <= edgeCount; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] adjList : adjWeights) {
            adj.get(adjList[0]).add(new DistancePair(adjList[1], adjList[2]));
            adj.get(adjList[1]).add(new DistancePair(adjList[0], adjList[2]));
        }
        PriorityQueue<DistancePair> minHeapQueue = new PriorityQueue<DistancePair>((a, b) -> a.distance - b.distance);
        int[] distMatrix = new int[nodeCount + 1];
        Arrays.fill(distMatrix, Integer.MAX_VALUE);
        int[] parentMatrix = new int[nodeCount + 1];

        for (int i = 0; i < nodeCount; i++) {
            parentMatrix[i] = i;
        }

        distMatrix[1] = 0;
        minHeapQueue.add(new DistancePair(1, 0));
        while (!minHeapQueue.isEmpty()) {
            DistancePair dp = minHeapQueue.poll();
            int srcNode = dp.node;
            int oldDist = dp.distance;
            for (DistancePair nextNode : adj.get(srcNode)) {
                if ((oldDist + nextNode.distance) < distMatrix[nextNode.node]) {
                    distMatrix[nextNode.node] = oldDist + nextNode.distance;
                    parentMatrix[nextNode.node] = srcNode;
                    minHeapQueue.add(new DistancePair(nextNode.node, distMatrix[nextNode.node]));
                }
            }

        }
        if (distMatrix[destination] == Integer.MAX_VALUE)
            return new ArrayList<>(Arrays.asList(-1));
        ArrayList<Integer> pathNodes = new ArrayList<>();
        int destiNode = destination;
        while (parentMatrix[destiNode] != destiNode) {
            pathNodes.add(destiNode);
            destiNode = parentMatrix[destiNode];

        }

        pathNodes.add(source);
        Collections.reverse(pathNodes);

        return pathNodes;
    }

    public static void main(String[] args) {
        int nodeCount = 6;
        int edgeCount = 8;
        int destination = 6;
        int[][] edges = {
                { 1, 2, 4 },
                { 1, 3, 4 },
                { 2, 3, 2 },
                { 3, 4, 3 },
                { 3, 5, 1 },
                { 3, 6, 6 },
                { 4, 6, 2 },
                { 5, 6, 3 }
        };

        ArrayList<Integer> path = DijkstrasShortestPath.getShortestPathNodes(nodeCount, edgeCount, edges, destination);
        System.out.println("Shortest Path   :" + path);
    }

}
