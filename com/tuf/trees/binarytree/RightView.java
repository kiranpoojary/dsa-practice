package com.tuf.trees.binarytree;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=KV4mRzTjlAk&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=96
public class RightView {
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

    public ArrayList<Integer> getRightViewNode(Node node, int level, ArrayList<Integer> rightNodes) {
        // follow level order, same as top view but no need to check
        if (node == null)
            return rightNodes;
        if (rightNodes.size() == level)
            rightNodes.add(node.value);
        if (node.right != null)
            getRightViewNode(node.right, level + 1, rightNodes);
        if (node.left != null)
            getRightViewNode(node.left, level + 1, rightNodes);
        return rightNodes;
    }

    public static void main(String[] args) {
        RightView tree = new RightView();
        tree.createTree();
        ArrayList<Integer> rightNodes = new ArrayList<>();
        rightNodes = tree.getRightViewNode(tree.root, 0, rightNodes);
        System.out.println(rightNodes);
    }

}
