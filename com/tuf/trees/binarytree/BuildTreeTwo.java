package com.tuf.trees.binarytree;

import java.util.HashMap;

public class BuildTreeTwo {
    // Build tree from provided inorder and preoder traversal
    public static void initiateTreeBuild(int[] postOrder, int[] inOrder) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            mp.put(inOrder[i], i);
        }
        Node root = buildTree(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1, mp);
        InorderTraversal i = new InorderTraversal();
        System.out.println("In-Order");
        i.inorderTraversal(root);
        System.out.println();
        System.out.println("Post-Order");
        PostorderTraversal p = new PostorderTraversal();
        p.postOrderTraversal(root);

    }

    public static Node buildTree(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd,
            HashMap<Integer, Integer> inMapper) {

        if (postStart > postEnd || inStart > inEnd)
            return null;
        Node root = new Node(postOrder[postEnd]);
        int rootIndexInInOrder = inMapper.get(root.value);
        int numsLeft = rootIndexInInOrder - inStart; // 0 indexing
        root.left = buildTree(postOrder, postStart, postStart + numsLeft - 1, inOrder, inStart, rootIndexInInOrder - 1,
                inMapper);
        root.right = buildTree(postOrder, postStart + numsLeft, postEnd - 1, inOrder, rootIndexInInOrder + 1, inEnd,
                inMapper);
        return root;
    }

    public static void main(String[] args) {
        BuildTreeTwo b = new BuildTreeTwo();
        int[] postOrder = { 40, 50, 20, 60, 30, 10 };
        int[] inOrder = { 40, 20, 50, 10, 60, 30 };
        b.initiateTreeBuild(postOrder, inOrder);
    }
}
