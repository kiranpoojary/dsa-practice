package com.tuf.trees.binarytree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CountCompleteTreeNodes {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right = new Node(5);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    }

    public int getCompleteTreeCount(Node root) {
        if (root == null)
            return 0;
        int lh = this.getLeftHeight(root);
        int rh = this.getRightHeight(root);
        if (lh == rh)
            return (int) (Math.pow(2, lh)) - 1;
        else
            return 1 + getCompleteTreeCount(root.left) + getCompleteTreeCount(root.right);
    }

    private int getLeftHeight(Node node) {
        if (node == null)
            return 0;
        int h = 1;
        while (node.left != null) {
            ++h;
            node = node.left;
        }
        return h;
    }

    private int getRightHeight(Node node) {
        if (node == null)
            return 0;
        int h = 1;
        while (node.right != null) {
            ++h;
            node = node.right;
        }
        return h;
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes tree = new CountCompleteTreeNodes();
        tree.createTree();
        System.out.println("Node count     : " + tree.getCompleteTreeCount(tree.root));

    }

}
