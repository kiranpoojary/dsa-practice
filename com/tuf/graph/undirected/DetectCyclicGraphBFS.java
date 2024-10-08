package com.tuf.graph.undirected;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PairDetectCyCleBSF {
    int first;
    int second;

    public PairDetectCyCleBSF(int a, int b) {
        this.first = a;
        this.second = b;
    }

}

public class DetectCyclicGraphBFS {

    public static boolean hasCycleBFS(int startNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        boolean hasCycle = false;
        Queue<PairDetectCyCleBSF> q = new LinkedList<>();// <node and parent>
        q.add(new PairDetectCyCleBSF(startNode, -1));// <node and parent>
        visited[startNode] = true;
        while (!hasCycle && !q.isEmpty()) {
            PairDetectCyCleBSF node = q.poll();
            int currNode = node.first;
            int currNodeParent = node.second;
            for (Integer n : adjList.get(currNode)) {
                if (n == currNode)
                    continue;
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(new PairDetectCyCleBSF(n, currNode));
                } else if (currNodeParent != n) {
                    hasCycle = true;
                    break;
                }
            }

        }
        return hasCycle;
    }

    public static boolean checkCycleExist(ArrayList<ArrayList<Integer>> adj, int startNode) {
        boolean[] visited = new boolean[adj.size()];
        return hasCycleBFS(startNode, adj, visited);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList())); // 0 index
        adjList.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        adjList.add(new ArrayList<>(Arrays.asList(2, 1, 4)));
        adjList.add(new ArrayList<>(Arrays.asList(3, 1, 4)));
        adjList.add(new ArrayList<>(Arrays.asList(4, 2, 3)));

        System.out.println("Is Cyclic Graph  :" + checkCycleExist(adjList, 1));

    }
}
