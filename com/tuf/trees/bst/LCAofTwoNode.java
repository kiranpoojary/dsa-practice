package com.tuf.trees.bst;

public class LCAofTwoNode {
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

    public Node getLCA(Node root, Node node1, Node node2) {
        if (root == null)
            return null;
        if (root.value < node1.value && root.value < node2.value) { // both on right
            return getLCA(root.right, node1, node2);
        }
        if (root.value > node1.value && root.value > node2.value) { // both on left
            return getLCA(root.left, node1, node2);
        }

        return root;

    }

    public static void main(String[] args) {
        LCAofTwoNode tree = new LCAofTwoNode();
        tree.createTree();
        Node lcaNode = tree.getLCA(tree.root, tree.root.left.left, tree.root.left.right.left);
        System.out.println("LCA Node Value    :" + lcaNode.value);
    }
}
