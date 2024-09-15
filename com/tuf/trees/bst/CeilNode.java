package com.tuf.trees.bst;

class CeilNode {
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

    public Node getCeilNode(int k) {
        Node currCeil = null;
        while (root != null) {
            if (root.value == k) {
                currCeil = root;
                return currCeil;
            } else if (root.value > k) {
                currCeil = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return currCeil;
    }

    public static void main(String[] args) {
        CeilNode tree = new CeilNode();
        tree.createTree();
        Node ceilNode = tree.getCeilNode(9);
        if (ceilNode != null) {
            System.out.println("Found Ceil Node     :" + ceilNode.value);
        } else
            System.out.println("Ceil Node Not Found :");
    }

}