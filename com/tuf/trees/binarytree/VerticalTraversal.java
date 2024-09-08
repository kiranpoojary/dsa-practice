package com.tuf.trees.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class NodeInfo implements Comparable<NodeInfo> {
    Node node;
    int verticalColumn;
    int levelRow;

    public NodeInfo(int verticalColumn, int levelRow, Node node) {
        this.verticalColumn = verticalColumn;
        this.levelRow = levelRow;
        this.node = node;
    }

    @Override
    public int compareTo(NodeInfo other) {
        int result = Integer.compare(this.verticalColumn, other.verticalColumn);
        if (result == 0) {
            return Integer.compare(this.levelRow, other.levelRow);
        }
        return result;
    }
}

public class VerticalTraversal {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(9);
    }

    public void getVerticalTraversal() {
        if (root == null)
            return;
        Queue<NodeInfo> pq = new PriorityQueue<>();
        Queue<NodeInfo> q = new LinkedList();

        q.add(new NodeInfo(0, 0, root));
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                NodeInfo frontNode = q.poll();
                if (frontNode.node.left != null)
                    q.add(new NodeInfo(frontNode.verticalColumn - 1, frontNode.levelRow + 1, frontNode.node.left));
                if (frontNode.node.right != null)
                    q.add(new NodeInfo(frontNode.verticalColumn + 1, frontNode.levelRow + 1, frontNode.node.right));
                pq.add(frontNode);
            }
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll().node.value + " ");
        }

    }

    public static void main(String[] args) {
        VerticalTraversal tree = new VerticalTraversal();
        tree.createTree();
        tree.getVerticalTraversal();

    }

}
