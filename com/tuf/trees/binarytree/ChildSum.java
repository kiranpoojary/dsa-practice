package com.tuf.trees.binarytree;

public class ChildSum {
    Node root;

    public void createTree() {
        root = new Node(40);

        root.left = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(5);

        root.right = new Node(20);
        root.right.right = new Node(30);
        root.right.left = new Node(40);
    }

    public void createChildSumTree(Node root) {
        if (root == null)
            return;
        int childTotal = 0;
        if (root.left != null)
            childTotal += root.left.value;
        if (root.right != null)
            childTotal += root.right.value;
        if (childTotal >= root.value)
            root.value = childTotal;
        else {
            if (root.left != null)
                root.left.value = root.value;
            else if (root.right != null)
                root.right.value = root.value;
        }
        createChildSumTree(root.left);
        createChildSumTree(root.right);
        int rootNewTotal = 0;
        if (root.left != null)
            rootNewTotal += root.left.value;
        if (root.right != null)
            rootNewTotal += root.right.value;
        if (root.left != null || root.right != null)
            root.value = rootNewTotal;
    }

    public static void main(String[] args) {
        ChildSum tree = new ChildSum();
        tree.createTree();
        InorderTraversal inOrder = new InorderTraversal();
        inOrder.inorderTraversal(tree.root);
        tree.createChildSumTree(tree.root);
        System.out.println();
        inOrder.inorderTraversal(tree.root);

    }
}
