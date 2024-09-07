package com.tuf.trees.binarytree;

public class NodePair {
    private Node node;
    private int count;

    public NodePair(Node node, int count) {
        this.node = node;
        this.count = count;
    }

    public Node getNode() {
        return node;
    }

    public int getCount() {
        return count;
    }

    public int setCount(int newCount) {
        this.count = newCount;
        return newCount;
    }
}
