package com.tuf.trees.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversal {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);

        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);
    }

    public ArrayList getLeftBoundary(Node root, ArrayList arr) {
        if (root == null)
            return arr;
        if (root.left != null || root.right != null) {
            arr.add(root);
            if (root.left != null) {
                return getLeftBoundary(root.left, arr);
            } else
                return getLeftBoundary(root.right, arr);
        }
        return arr;
    }

    public ArrayList getLeafBoundary(Node root, ArrayList arr) {
        if (root == null)
            return arr;
        if (root.left == null && root.right == null) {
            arr.add(root);
            return arr;
        }
        if (root.left != null)
            getLeafBoundary(root.left, arr);
        if (root.right != null)
            getLeafBoundary(root.right, arr);
        return arr;
    }

    public ArrayList getRightReverseBoundary(Node root, ArrayList arr) {
        if (root == null)
            return arr;
        Stack<Node> st = new Stack<>();
        while (root != null) {
            if (root.right != null) {
                st.add(root);
                root = root.right;
            } else if (root.left != null) {
                st.add(root);
                root = root.left;
            } else
                root = null;
        }
        while (!st.isEmpty()) {
            arr.add(st.pop());
        }
        return arr;
    }

    public void getBoundary(Node root) {
        if (root == null)
            return;
        ArrayList<Node> boundary = new ArrayList<>();
        boundary.add(root);
        getLeftBoundary(root.left, boundary);
        getLeafBoundary(root, boundary);
        getRightReverseBoundary(root.right, boundary);
        for (Node node : boundary) {
            System.out.print(node.value + " ");
        }

    }

    public static void main(String[] args) {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.createTree();
        tree.getBoundary(tree.root);

    }

}
