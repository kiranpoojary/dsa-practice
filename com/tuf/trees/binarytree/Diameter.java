package com.tuf.trees.binarytree;

public class Diameter {
    Node root;
    int maxDiameter = 0;

    public void initiateStructuredInsertNode(int val1, int val2, int val3, int val4, int val5, int val6, int val7,
            int val8, int val9) {
        // The diameter of a binary tree is the length of the longest path between any
        // two nodes in a tree.

        root = new Node(val1);

        root.left = new Node(val2);

        root.right = new Node(val3);
        root.right.left = new Node(val4);
        root.right.left.left = new Node(val5);
        root.right.left.left.left = new Node(val6);

        root.right.right = new Node(val7);
        root.right.right.right = new Node(val8);
        root.right.right.right.right = new Node(val8);

    }

    // diameter is the longest path exist in a tree btw 2 nodes
    public int getTreeDiameter(Node currNode, int diameter) {
        if (currNode == null)
            return 0;
        int lh = getTreeDiameter(currNode.left, diameter);
        int rh = getTreeDiameter(currNode.right, diameter);
        diameter = Math.max(diameter, (lh + rh));
        return 1 + Math.max(lh, rh);

    }

    public static void main(String[] args) {
        Diameter tree = new Diameter();
        tree.initiateStructuredInsertNode(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Diameter   : " + tree.getTreeDiameter(tree.root, tree.maxDiameter));
    }
}
