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
        root.left.right = new Node(6);

        root.right = new Node(7);
        root.right.right = new Node(4);
        root.right.left = new Node(40);

    }

    public int getMaxWidth(Node root) { // follow level order
        int maxWidth = 0;
        if (root == null)
            return maxWidth;
        Queue<QueueNode> q = new LinkedList<>();

        QueueNode qn = new QueueNode(root, 0);
        q.add(qn);

        while (!q.isEmpty()) {
            QueueNode firstNode = q.poll();
            QueueNode lastNode = firstNode;
            while (!q.isEmpty()) {
                lastNode = q.poll();
            }

            int firstParentIndex = firstNode.index > 0 ? firstNode.index - 1 : firstNode.index;
            int secondParentIndex = lastNode.index > 0 ? lastNode.index - 1 : lastNode.index;
            if (firstNode.node != null && firstNode != lastNode) {
                if (firstNode.node.left != null) {
                    int newNodeIndex = q.isEmpty() ? 2 * firstParentIndex + 1 : 2 * secondParentIndex + 2;
                    QueueNode qn1 = new QueueNode(firstNode.node.left, newNodeIndex);
                    q.add(qn1);
                }
                if (firstNode.node.right != null) {
                    int newNodeIndex = q.isEmpty() ? 2 * firstParentIndex + 1 : 2 * secondParentIndex + 2;
                    QueueNode qn1 = new QueueNode(firstNode.node.right, newNodeIndex);
                    q.add(qn1);
                }
                if (lastNode.node.left != null) {
                    int newNodeIndex = q.isEmpty() ? 2 * firstParentIndex + 1 : 2 * secondParentIndex + 2;
                    QueueNode qn1 = new QueueNode(lastNode.node.left, newNodeIndex);
                    q.add(qn1);
                }
                if (lastNode.node.right != null) {
                    int newNodeIndex = q.isEmpty() ? 2 * firstParentIndex + 1 : 2 * secondParentIndex + 2;
                    QueueNode qn1 = new QueueNode(lastNode.node.right, newNodeIndex);
                    q.add(qn1);
                }
            } else if (firstNode.node != null) {
                if (firstNode.node.left != null) {
                    int newNodeIndex = q.isEmpty() ? 2 * firstParentIndex + 1 : 2 * secondParentIndex + 2;
                    QueueNode qn1 = new QueueNode(firstNode.node.left, newNodeIndex);
                    q.add(qn1);
                }
                if (firstNode.node.right != null) {
                    int newNodeIndex = q.isEmpty() ? 2 * firstParentIndex + 1 : 2 * secondParentIndex + 2;
                    QueueNode qn1 = new QueueNode(firstNode.node.right, newNodeIndex);
                    q.add(qn1);
                }
            }
            int width = lastNode.index - firstNode.index + 1;
            maxWidth = Math.max(maxWidth, width);
        }
        return maxWidth;
    }

    public int getMaxWidthOverflow(Node root) {
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
        System.out.println("Max Width no overflow  : " + tree.getMaxWidth(tree.root));
        System.out.println("Max Width  overflow    : " + tree.getMaxWidthOverflow(tree.root));

    }

}