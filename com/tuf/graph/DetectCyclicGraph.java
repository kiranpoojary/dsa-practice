package com.tuf.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Pair
 */
class Pair {
    int first;
    int second;

    public Pair(int a, int b) {
        this.first = a;
        this.second = b;
    }

}

public class DetectCyclicGraph {

    public static boolean hasCycle(int startNode, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        boolean hasCycle = false;
        Queue<Pair> q = new LinkedList<>();// <node and parent>
        q.add(new Pair(startNode, -1));// <node and parent>
        visited[startNode] = true;
        while (!hasCycle && !q.isEmpty()) {
            Pair node = q.poll();
            int currNode = node.first;
            int currNodeParent = node.second;
            for (Integer n : adjList.get(currNode)) {
                if (n == currNode)
                    continue;
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(new Pair(n, currNode));
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
        return hasCycle(startNode, adj, visited);
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
