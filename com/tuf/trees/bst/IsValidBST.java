package com.tuf.trees.bst;

public class IsValidBST {
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

    public boolean isBST(Node root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkBST(Node root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.value >= maxVal || root.value <= minVal)
            return false;
        return checkBST(root.left, minVal, root.value) && checkBST(root.right, root.value, maxVal);
    }

    public static void main(String[] args) {
        IsValidBST tree = new IsValidBST();
        tree.createTree();
        System.out.println("Is valid BST  :" + tree.isBST(tree.root));

    }
}
