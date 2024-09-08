package com.tuf.trees.binarytree;

import java.util.ArrayList;

// https://www.youtube.com/watch?v=_-QHfMDde90&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=99

public class LowestCommonAncestor {

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

    public Node getLowestCommonAncestor(Node root, int i, int j) {
        if (root == null || root.value == i || root.value == j)
            return root;
        Node left = getLowestCommonAncestor(root.left, i, j);
        Node right = getLowestCommonAncestor(root.right, i, j);
        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.createTree();
        ArrayList<Integer> path = new ArrayList<>();
        Node commonAnc = tree.getLowestCommonAncestor(tree.root, 6, 9);
        System.out.println("Common Lowest Ancestor  : " + commonAnc.value);

    }

}