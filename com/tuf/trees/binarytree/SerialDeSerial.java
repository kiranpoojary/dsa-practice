package com.tuf.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerialDeSerial {
    Node root;

    public void createTree() {
        root = new Node(10);

        root.left = new Node(20);
        root.left.left = new Node(40);

        root.right = new Node(30);
        root.right.left = new Node(50);
        root.right.right = new Node(60);
    }

    public String getSerializedTree(Node root) {
        String str = "";
        if (root == null)
            return str;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node currNode = q.poll();
            if (currNode == null)
                str += "n ";
            else {
                str += currNode.value + " ";
                q.offer(currNode.left);
                q.offer(currNode.right);
            }
        }
        return str;
    }

    public Node deSerializeTree(String data) {
        if (data == " ")
            return null;
        String[] nodes = data.split(" ");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(nodes[0]));
        q.offer(root);
        for (int i = 1; i < nodes.length; i++) {
            Node parent = q.poll();
            if (!nodes[i].equals("n")) {
                parent.left = new Node(Integer.parseInt(nodes[i]));
                q.offer(parent.left);
            }

            if (!nodes[++i].equals("n")) {
                parent.right = new Node(Integer.parseInt(nodes[i]));
                q.offer(parent.right);

            }

        }

        return root;
    }

    public static void main(String[] args) {
        SerialDeSerial tree = new SerialDeSerial();
        tree.createTree();
        String serialized = tree.getSerializedTree(tree.root);
        System.out.println("Serialized    : " + serialized);
        Node newRoot = tree.deSerializeTree(serialized);
        LevelorderTraversal l = new LevelorderTraversal();
        System.out.print("DeSerialized  : ");
        l.levelOrderTraversal(newRoot);

    }

}
