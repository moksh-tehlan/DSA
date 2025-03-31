package binarytree.medium;

import binarytree.traversal.TreeNode;

public class BalancedBinaryTree {
    public static void main(String[] args) {

    }

    private static boolean isBalanced(TreeNode root) {
        return heightCalculator(root) != -1;
    }

    private static int heightCalculator(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = heightCalculator(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = heightCalculator(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(rightHeight - leftHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}