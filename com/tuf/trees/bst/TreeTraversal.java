package com.tuf.trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversal {

    public void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.value + " ");
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }

    }

    public List<List<Integer>> returnLevelOrderNodes(Node root) {
        System.out.println();
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> allLevelList = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);
                levelList.add(q.poll().value);
            }
            allLevelList.add(levelList);
        }
        return allLevelList;

    }

}
