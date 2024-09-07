package com.tuf.trees.binarytree;

import java.lang.reflect.Array;

public class MaxPathSum {
    Node root;
    int max = 0;

    public void createTree() {
        root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
    }

    public int getMaxPathSum(Node currNode, int[] max) {
        if (currNode == null)
            return 0;
        int lh = Math.max(0, getMaxPathSum(currNode.left, max));
        int rh = Math.max(0, getMaxPathSum(currNode.right, max));
        max[0] = Math.max(max[0], (currNode.value + lh + rh));
        return Math.max(lh, rh) + currNode.value;
    }

    public static void main(String[] args) {
        MaxPathSum tree = new MaxPathSum();
        tree.createTree();
        int[] max = { 1 };
        tree.getMaxPathSum(tree.root, max);
        System.out.println("Max Depth   : " + max[0]);
    }

}
