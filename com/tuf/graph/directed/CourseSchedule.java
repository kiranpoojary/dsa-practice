package com.tuf.graph.directed;

import java.util.*;

// https://youtube.com/watch?v=WAOfKpxYHR8&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=151&t=560s

public class CourseSchedule {

    public static ArrayList<Integer> canFinishAllScheduledTaskBSF(ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] indegree = new int[adjList.size()];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < adjList.size(); i++) {
            ArrayList<Integer> arr = adjList.get(i);
            for (Integer node : arr) {
                indegree[node]++;
            }

        }

        for (int i = 0; i < indegree.length; i++) {
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

        if (ans.size() == adjList.size())
            return ans;
        else
            return new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> taskList1 = new ArrayList<>();

        taskList1.add(new ArrayList<>(Arrays.asList()));
        taskList1.add(new ArrayList<>(Arrays.asList(0, 1)));
        taskList1.add(new ArrayList<>(Arrays.asList(1, 2)));
        taskList1.add(new ArrayList<>(Arrays.asList(2, 3)));
        // -------
        ArrayList<ArrayList<Integer>> taskList2 = new ArrayList<>();
        taskList2.add(new ArrayList<>(Arrays.asList()));
        taskList2.add(new ArrayList<>(Arrays.asList(1, 2)));
        taskList2.add(new ArrayList<>(Arrays.asList(4, 3)));
        taskList2.add(new ArrayList<>(Arrays.asList(2, 4)));
        taskList2.add(new ArrayList<>(Arrays.asList(4, 1)));

        System.out.println("can finish all task-dfs-1      :" + canFinishAllScheduledTaskBSF(taskList1));
        System.out.println("can finish all task-dfs-2      :" + canFinishAllScheduledTaskBSF(taskList2));

    }

}
