package com.tuf.trees.bst;

public class ConstructBSTFromPre {
    Node root;

    public Node buildBSTFromPreorder(int[] preOrder) {
        return buildBST(preOrder, Integer.MAX_VALUE, new int[] { 0 });
    }

    public Node buildBST(int[] preOrder, int maxBound, int[] i) {
        if (i[0] == preOrder.length || preOrder[i[0]] > maxBound)
            return null;
        Node root = new Node(preOrder[i[0]++]);
        root.left = buildBST(preOrder, root.value, i);
        root.right = buildBST(preOrder, maxBound, i);
        return root;
    }

    public static void main(String[] args) {
        ConstructBSTFromPre tree = new ConstructBSTFromPre();
        int[] preOrder = { 8, 5, 4, 7, 6, 12, 10, 14, 13 };
        Node root = tree.buildBSTFromPreorder(preOrder);
        TreeTraversal t = new TreeTraversal();
        t.levelOrderTraversal(root);
        System.out.println(t.returnLevelOrderNodes(root));
    }
}
