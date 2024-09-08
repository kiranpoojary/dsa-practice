package com.tuf.trees.binarytree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class NodeLineInfo {
    Node node;
    int line;

    public NodeLineInfo(int line, Node node) {
        this.line = line;
        this.node = node;
    }

}

public class TopView {
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

    private Map<Integer, Node> buildMapEntry(int key, Node value) {
        Map<Integer, Node> mp = new HashMap<>();
        mp.put(key, value);
        return mp;
    }

    public void getTopViewNode() {
        if (root == null)
            return;
        Map<Integer, Node> mp = new TreeMap<>();
        Queue<Map<Integer, Node>> q = new LinkedList<>();
        q.add(buildMapEntry(0, root));
        while (!q.isEmpty()) {
            Map<Integer, Node> frontNode = q.poll();
            Set<Integer> keys = frontNode.keySet();
            Integer line = keys.iterator().next(); // always have one key so
            if (!mp.containsKey(line)) {
                mp.put(line, frontNode.get(line));
            }

            if (frontNode.get(line).left != null)
                q.add(buildMapEntry(line - 1, frontNode.get(line).left));
            if (frontNode.get(line).right != null)
                q.add(buildMapEntry(line + 1, frontNode.get(line).right));
        }
        for (Map.Entry<Integer, Node> entry : mp.entrySet()) {
            Integer key = entry.getKey();
            Node node = entry.getValue();
            System.out.print(node.value + " ");
        }
    }

    public static void main(String[] args) {
        TopView tree = new TopView();
        tree.createTree();
        tree.getTopViewNode();

    }

}
