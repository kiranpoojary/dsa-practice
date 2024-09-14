package com.tuf.trees.binarytree;

import java.util.LinkedList;
import java.util.Stack;

public class FlattenTree {
    Node root;
    Node prev = null;

    public void createTree() {
        root = new Node(10);

        root.left = new Node(20);
        root.left.left = new Node(40);

        root.right = new Node(30);
        root.right.left = new Node(50);
        root.right.right = new Node(60);
    }

    public void flattenTree(Node root) {
        if (root == null)
            return;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node topNode = st.pop();
            if (topNode.right != null) {
                st.push(topNode.right);
            }
            if (topNode.left != null) {
                st.push(topNode.left);
            }
            if (!st.isEmpty())
                topNode.right = st.peek();
            topNode.left = null;

        }
    }

    public static void main(String[] args) {
        FlattenTree tree = new FlattenTree();
        tree.createTree();
        Node root = tree.root;
        tree.flattenTree(tree.root);
        while (root != null) {
            System.out.print(root.value + " ");
            root = root.right;

        }

    }

}
