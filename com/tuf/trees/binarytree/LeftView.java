package com.tuf.trees.binarytree;

import java.util.ArrayList;

public class LeftView {
    Node root;

    public void createTree() {
        root = new Node(1);

        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(10);
        root.right.right.right = new Node(9);
    }

    public ArrayList<Integer> getRightViewNode(Node node, int level, ArrayList<Integer> leftNodes) {
        // follow level order, same as top view but no need to check
        if (node == null)
            return leftNodes;
        if (leftNodes.size() == level)
            leftNodes.add(node.value);
        if (node.left != null)
            getRightViewNode(node.left, level + 1, leftNodes);
        if (node.right != null)
            getRightViewNode(node.right, level + 1, leftNodes);
        return leftNodes;
    }

    public static void main(String[] args) {
        LeftView tree = new LeftView();
        tree.createTree();
        ArrayList<Integer> leftNodes = new ArrayList<>();
        leftNodes = tree.getRightViewNode(tree.root, 0, leftNodes);
        System.out.println(leftNodes);
    }

}
