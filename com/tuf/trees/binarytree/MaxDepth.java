package com.tuf.trees.binarytree;

public class MaxDepth {
    Node root;

    public void initiateStructuredInsertNode(int val1, int val2, int val3, int val4, int val5, int val6, int val7) {
        root = new Node(val1);
        root.left = new Node(val2);
        root.right = new Node(val3);
        root.right.left = new Node(val4);
        root.right.left.left = new Node(val5);
        root.right.right = new Node(val6);
    }

    public int getMaxDepth(Node currNode) {
        if (currNode == null)
            return 0;
        int lh = getMaxDepth(currNode.left);
        int rh = getMaxDepth(currNode.right);
        int max = 1 + Math.max(lh, rh);
        return max;

    }

    public static void main(String[] args) {
        MaxDepth tree = new MaxDepth();
        tree.initiateStructuredInsertNode(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Max Depth   : " + tree.getMaxDepth(tree.root));
    }
}
