package com.tuf.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelorderTraversal {
    Node root;

    public void insertTreeNode(Node currNode, int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        if (currNode.left == null)
            currNode.left = new Node(val);
        else if (currNode.right == null)
            currNode.right = new Node(val);
        else
            insertTreeNode(currNode.left, val);
    }

    public void initiateInsertNode(int val) {
        insertTreeNode(root, val);
    }

    public void levelOrderTraversal() {
        if (root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            if (q.peek().left != null)
                q.offer(q.peek().left);
            if (q.peek().right != null)
                q.offer(q.peek().right);
            System.out.print(q.poll().value + " ");
        }
    }

    public List<List<Integer>> returnLevelOrderNodes() {
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

    public void initiateLevelOrderTraversal() {
        levelOrderTraversal();
        System.out.println(returnLevelOrderNodes());
    }

    public static void main(String[] args) {
        LevelorderTraversal tree = new LevelorderTraversal();
        tree.initiateInsertNode(44);
        tree.initiateInsertNode(30);
        tree.initiateInsertNode(144);
        tree.initiateInsertNode(90);
        tree.initiateInsertNode(26);
        tree.initiateInsertNode(445);
        tree.initiateInsertNode(48);
        tree.initiateLevelOrderTraversal();

    }
}
