package com.tuf.trees.binarytree;

public class CheckIdenticalTree {
    Node root;
    int max = 0;

    public void createTreeOne() {
        root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
    }

    public void createTreeTwo() {
        root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
    }

    public static boolean isIdenticalTree(Node node1, Node node2) {
        if (node1 == null && node2 == null)
            return true;
        else if (node1.value != node2.value)
            return false;
        boolean isLeftSame = isIdenticalTree(node1.left, node2.left);
        boolean isRightSame = isIdenticalTree(node1.right, node2.right);
        return isLeftSame && isRightSame;
    }

    public static void main(String[] args) {
        CheckIdenticalTree tree1 = new CheckIdenticalTree();
        tree1.createTreeOne();
        CheckIdenticalTree tree2 = new CheckIdenticalTree();
        tree2.createTreeTwo();
        System.out.println("isIdenticalTree    : " + isIdenticalTree(tree1.root, tree2.root));
    }
}
