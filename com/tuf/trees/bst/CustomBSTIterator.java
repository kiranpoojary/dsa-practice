package com.tuf.trees.bst;

import java.util.LinkedList;
import java.util.Stack;

public class CustomBSTIterator {
    // IMPLEMENT BST InOrder Iterator
    Node root;
    Stack<Node> st = new Stack<>();

    public CustomBSTIterator() {
        this.createTree();
        this.st.add(root);
        this.pushAll(root);

    }

    public void createTree() {
        root = new Node(8);

        root.left = new Node(5);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);

        root.right = new Node(12);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
    }

    public boolean hasNext() {
        return !st.empty();
    }

    public Node nexNode() {
        Node next = st.pop();
        if (next.right != null) {
            st.add(next.right);
            pushAll(next.right);
        }
        return next;
    }

    public void pushAll(Node root) {
        while (root.left != null) {
            st.push(root.left);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        CustomBSTIterator tree = new CustomBSTIterator();
        System.out.println(tree.hasNext());
        System.out.println(tree.nexNode().value);
        System.out.println(tree.nexNode().value);
        System.out.println(tree.nexNode().value);
        System.out.println(tree.nexNode().value);
        System.out.println(tree.nexNode().value);
        System.out.println(tree.nexNode().value);
        System.out.println(tree.nexNode().value);
        System.out.println(tree.hasNext());
        System.out.println(tree.nexNode().value);
        System.out.println(tree.nexNode().value);
        System.out.println(tree.hasNext());

    }
}
