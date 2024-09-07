package com.tuf.trees.binarytree;

public class CheckBalancedBT {
    // A balanced binary tree or height-balanced binary tree is such a tree whose
    // left and right subtrees' heights differ by not more than 1, which means the
    // height difference could be -1, 0, and 1. A balanced binary tree is also known
    // as a height-balanced tree.

    Node root;

    public void initiateStructuredInsertNode(int val1, int val2, int val3, int val4, int val5, int val6, int val7) {
        root = new Node(val1);
        root.left = new Node(val2);
        root.right = new Node(val3);
        root.right.left = new Node(val4);
        root.right.right = new Node(val6);
    }

    public void _initiateStructuredInsertNode(int val1, int val2, int val3, int val4, int val5, int val6, int val7) {
        root = new Node(val1);
        root.left = new Node(val2);
        root.right = new Node(val3);

        root.left.left = new Node(val4);
        root.left.right = new Node(val5);

        root.left.left.left = new Node(val6);
        root.left.left.right = new Node(val7);

    }

    public int isBalancedBT(Node currNode) { // minor modification to maxHight problem
        if (currNode == null)
            return 0;
        int lh = isBalancedBT(currNode.left);
        if (lh == -1)
            return -1;
        int rh = isBalancedBT(currNode.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return Math.max(lh, rh) + 1;

    }

    public static void main(String[] args) {
        CheckBalancedBT tree1 = new CheckBalancedBT();
        tree1.initiateStructuredInsertNode(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Is Balance Tree-1   : " + !(tree1.isBalancedBT(tree1.root) == -1));

        CheckBalancedBT tree2 = new CheckBalancedBT();
        tree2._initiateStructuredInsertNode(1, 2, 3, 4, 5, 6, 7);
        System.out.println("Is Balance Tree-1   : " + !(tree2.isBalancedBT(tree2.root) == -1));

    }

}
