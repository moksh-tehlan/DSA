package binarytree.medium;

import binarytree.traversal.TreeNode;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {

    }


    private static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[]{0};
        heightCalculator(root,diameter);
        return diameter[0];
    }

    private static int heightCalculator(TreeNode root, int[] diameter) {
        if (root == null) return 0;
        int left = heightCalculator(root.left,diameter);
        int right = heightCalculator(root.right,diameter);
        diameter[0] = Math.max(diameter[0],left+right);
        return Math.max(left, right) + 1;
    }
}
