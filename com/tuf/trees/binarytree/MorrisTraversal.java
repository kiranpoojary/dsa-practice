package com.tuf.trees.binarytree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    Node root;

    public void createTree() {
        root = new Node(10);

        root.left = new Node(20);
        root.left.left = new Node(40);

        root.right = new Node(30);
        root.right.left = new Node(50);
        root.right.right = new Node(60);
    }

    public List<Integer> doMorrisInorderTraversal(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inOrder.add(curr.value);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inOrder.add(curr.value);
                    curr = curr.right;
                }
            }
        }
        return inOrder;
    }

    public List<Integer> doMorrisPreorderTraversal(Node root) {
        ArrayList<Integer> inOrder = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inOrder.add(curr.value);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    inOrder.add(curr.value);// here is change
                    curr = curr.left;
                } else {
                    prev.right = null;
                    // here is change
                    curr = curr.right;
                }
            }
        }
        return inOrder;
    }

    public static void main(String[] args) {
        MorrisTraversal tree = new MorrisTraversal();
        tree.createTree();
        System.out.println(tree.doMorrisInorderTraversal(tree.root));
        System.out.println(tree.doMorrisPreorderTraversal(tree.root));

    }
}
