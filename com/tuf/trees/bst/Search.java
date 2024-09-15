package com.tuf.trees.bst;

public class Search {
    Node root;

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

    public Node searchNode(Node root, int k) {
        while (root != null) {
            if (root.value == k)
                return root;
            if (k > root.value) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Search tree = new Search();
        tree.createTree();
        Node foundNode = tree.searchNode(tree.root, 6);
        if (foundNode != null) {
            System.out.println("Found");
        } else
            System.out.println("Not Found");
    }

}
