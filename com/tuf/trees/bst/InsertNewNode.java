package com.tuf.trees.bst;

import java.util.LinkedList;
import java.util.Queue;

import com.tuf.trees.binarytree.LevelorderTraversal;

public class InsertNewNode {
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

    public Node insertNewNode(int k) {
        if (root == null) {
            root = new Node(k);
            return root;
        }
        Node curr = root;
        while (true) {
            if (curr.value < k) {
                if (curr.right == null) {
                    curr.right = new Node(k);
                    break;
                } else
                    curr = curr.right;
            } else {
                if (curr.left == null) {
                    curr.left = new Node(k);
                    break;
                } else
                    curr = curr.left;
            }
        }
        return root;

    }

    public static void main(String[] args) {
        InsertNewNode tree = new InsertNewNode();
        tree.createTree();
        tree.insertNewNode(11);
        TreeTraversal t = new TreeTraversal();
        t.levelOrderTraversal(tree.root);

    }

}
