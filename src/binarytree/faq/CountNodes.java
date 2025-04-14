package binarytree.faq;

import binarytree.traversal.TreeNode;

public class CountNodes {
    public static void main(String[] args) {

    }

    private static int countNodes(TreeNode root) {
        //your code goes here
        if (root == null) {
            return 0;
        }
        int lh = findHeightLeft(root.left);
        int rh = findHeightRight(root.right);

        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private static int findHeightLeft(TreeNode node) {
        int height = 0;
        // Traverse left child until
        // reaching the leftmost leaf
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // Function to find the right height of a tree
    private static int findHeightRight(TreeNode node) {
        int height = 0;
        // Traverse right child until
        // reaching the rightmost leaf
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }
}
