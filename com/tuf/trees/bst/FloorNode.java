package com.tuf.trees.bst;

public class FloorNode {
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

    public Node getFloorNode(int k) {
        Node currFloor = null;
        while (root != null) {
            if (root.value == k)
                return root;
            else if (root.value > k) {
                root = root.left;
            } else {
                currFloor = root;
                root = root.right;
            }
        }
        return currFloor;
    }

    public static void main(String[] args) {
        FloorNode tree = new FloorNode();
        tree.createTree();
        Node floorNode = tree.getFloorNode(9);
        if (floorNode != null) {
            System.out.println("Found Floor Node     :" + floorNode.value);
        } else
            System.out.println("Floor Node Not Found :");
    }

}
