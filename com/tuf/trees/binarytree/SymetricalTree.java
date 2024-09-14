package com.tuf.trees.binarytree;

public class SymetricalTree {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

    }

    public Boolean checkSubtreeSymetry(Node leftNode, Node rightNode) {
        if (leftNode == null || rightNode == null)
            return leftNode == rightNode;
        if (leftNode.value != rightNode.value)
            return false;
        return checkSubtreeSymetry(leftNode.right, rightNode.left)
                && checkSubtreeSymetry(leftNode.left, rightNode.right);
    }

    public boolean checkSymetry() {
        return root == null || checkSubtreeSymetry(root.left, root.right);
    }

    public static void main(String[] args) {
        SymetricalTree tree = new SymetricalTree();
        tree.createTree();
        System.out.println("Is Symetrical tree   : " + tree.checkSymetry());
    }

}
