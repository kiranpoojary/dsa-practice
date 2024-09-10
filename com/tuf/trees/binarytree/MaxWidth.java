package com.tuf.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

class QueueNode {
    Node node;
    int index;

    public QueueNode(Node node, int index) {
        this.node = node;
        this.index = index;
    }

}

public class MaxWidth {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(3);
        root.left.left = new Node(8);

        root.right = new Node(7);
        root.right.right = new Node(4);

    }

    public int getMaxWidth(Node root) {
        if (root == null)
            return 0;

        int maxWidth = 0;
        Queue<QueueNode> q = new LinkedList<>();
        q.add(new QueueNode(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            QueueNode firstNode = q.peek();
            QueueNode lastNode = firstNode;

            for (int i = 0; i < size; i++) {
                QueueNode currentNode = q.poll();
                lastNode = currentNode;

                if (currentNode.node.left != null) {
                    q.add(new QueueNode(currentNode.node.left, 2 * currentNode.index + 1));
                }
                if (currentNode.node.right != null) {
                    q.add(new QueueNode(currentNode.node.right, 2 * currentNode.index + 2));
                }
            }
            maxWidth = Math.max(maxWidth, lastNode.index - firstNode.index + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        MaxWidth tree = new MaxWidth();
        tree.createTree();
        System.out.println("Max Width  : " + tree.getMaxWidth(tree.root));

    }

}