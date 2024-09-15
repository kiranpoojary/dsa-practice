package com.tuf.trees.bst;
// https://www.youtube.com/watch?v=SXKAD2svfmI&list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz&index=121

public class InorderSuccPred {
    Node root;
    // successor: immidiate node where node.value > k.value
    // predecessor: nearest node where node.value < k.value
    // write inorder traversal and check

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

    public Node getInorderSuccessor(Node root, Node k) {
        Node successor = null;
        while (root != null) {
            if (k.value >= root.value) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;

    }

    public Node getInorderPredecessor(Node root, Node k) {
        Node predecessor = null;
        while (root != null) {
            if (root.value >= k.value) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }

        return predecessor;
    }

    public static void main(String[] args) {
        InorderSuccPred tree = new InorderSuccPred();
        tree.createTree();
        Node successor = tree.getInorderSuccessor(tree.root, tree.root.right);
        System.out.println("Successor :" + successor.value);
        Node predecesor = tree.getInorderPredecessor(tree.root, tree.root.right);
        System.out.println("Predecesor :" + predecesor.value);

    }

}
