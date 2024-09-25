package com.tuf.graph.directed;

import java.util.*;

public class TopoCycleDetectBSF {
    // is a toposort contains n element then its DAG
    // if toposort contains less than N elel, it contains a cycle: YES YES YES
    // TC:O(v+E) SC: O(2n)

    public static boolean checkCycleInDG(ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegree = new int[adjList.size()];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < adjList.size(); i++) {
            ArrayList<Integer> arr = adjList.get(i);
            for (Integer node : arr) {
                indegree[node]++;
            }

        }

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (Integer it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }

        return ans.size() < adjList.size();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        adjList.add(new ArrayList<>(Arrays.asList()));
        adjList.add(new ArrayList<>(Arrays.asList(2)));
        adjList.add(new ArrayList<>(Arrays.asList(3)));
        adjList.add(new ArrayList<>(Arrays.asList(4, 5)));
        adjList.add(new ArrayList<>(Arrays.asList(2)));
        adjList.add(new ArrayList<>(Arrays.asList()));
        System.out.println("is cyclic directed graph      :" + checkCycleInDG(adjList));

    }

}
