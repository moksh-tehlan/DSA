package binarytree.medium;

import binarytree.traversal.TreeNode;

public class MaximumDepth {
    static int maxDepth = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}